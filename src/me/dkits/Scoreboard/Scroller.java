package me.dkits.Scoreboard;

import java.util.ArrayList;
import org.bukkit.ChatColor;
import java.util.List;

public class Scroller
{
    private static final char COLOUR_CHAR = '§';
    private int position;
    private List<String> list;
    private ChatColor colour;
    private String cor;
    
    public Scroller(String message, int width, int spaceBetween, final String cor) {
        this.list = new ArrayList<String>();
        this.colour = ChatColor.RESET;
        if (cor != null) {
            this.cor = cor;
        }
        if (message.length() < width) {
            final StringBuilder sb = new StringBuilder(message);
            while (sb.length() < width) {
                sb.append(" ");
            }
            message = sb.toString();
        }
        width -= 2;
        if (width < 1) {
            width = 1;
        }
        if (spaceBetween < 0) {
            spaceBetween = 0;
        }
        for (int i = 0; i < message.length() - width; ++i) {
            this.list.add(message.substring(i, i + width));
        }
        final StringBuilder space = new StringBuilder();
        for (int j = 0; j < spaceBetween; ++j) {
            this.list.add(String.valueOf(message.substring(message.length() - width + ((j > width) ? width : j), message.length())) + (Object)space);
            if (space.length() < width) {
                space.append(" ");
            }
        }
        for (int j = 0; j < width - spaceBetween; ++j) {
            this.list.add(String.valueOf(message.substring(message.length() - width + spaceBetween + j, message.length())) + (Object)space + message.substring(0, j));
        }
        for (int j = 0; j < spaceBetween && j <= space.length(); ++j) {
            this.list.add(String.valueOf(space.substring(0, space.length() - j)) + message.substring(0, width - ((spaceBetween > width) ? width : spaceBetween) + j));
        }
    }
    
    public String next() {
        StringBuilder sb = this.getNext();
        if (sb.charAt(sb.length() - 1) == '§') {
            sb.setCharAt(sb.length() - 1, ' ');
        }
        if (sb.charAt(0) == '§') {
            final ChatColor c = ChatColor.getByChar(sb.charAt(1));
            if (c != null) {
                this.colour = c;
                sb = this.getNext();
                if (sb.charAt(0) != ' ') {
                    sb.setCharAt(0, ' ');
                }
            }
        }
        final String msg = (this.cor != null) ? this.cor : "";
        return String.valueOf(msg) + sb.toString();
    }
    
    private StringBuilder getNext() {
        return new StringBuilder(this.list.get(this.position++ % this.list.size()).substring(0));
    }
}
