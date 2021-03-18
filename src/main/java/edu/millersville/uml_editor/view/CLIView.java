package edu.millersville.uml_editor.view;

import java.util.Scanner;

public class CLI {

    public static void main(String[] args) {
       
    Terminal terminal = TerminalBuilder.builder()
    .name("Presto")
    .build();

reader = LineReaderBuilder.builder()
    .terminal(terminal)
    .variable(HISTORY_FILE, historyFile)
    .variable(SECONDARY_PROMPT_PATTERN, colored("%P -> "))
    .variable(BLINK_MATCHING_PAREN, 0)
    .parser(new InputParser())
    .highlighter(new InputHighlighter())
    .completer(new AggregateCompleter(completers))
    .build();
    }


    public void console() {
        Scanner console = new Scanner(System.in);
        String input = console.nextLine();
        
        switch(input) {
            case "add":
            
        }
    }
}
