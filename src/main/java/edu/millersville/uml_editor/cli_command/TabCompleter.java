package edu.millersville.uml_editor.cli_command;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import org.jline.reader.Completer;
import org.jline.reader.impl.completer.AggregateCompleter;
import org.jline.reader.impl.completer.ArgumentCompleter;
import org.jline.reader.impl.completer.NullCompleter;
import org.jline.reader.impl.completer.StringsCompleter;

import edu.millersville.uml_editor.model.*;

public class TabCompleter {

	private AggregateCompleter completer;

    public TabCompleter() {
        this.completer = new AggregateCompleter(
                new ArgumentCompleter(
                        new StringsCompleter("save"),
                        new NullCompleter()
                ),
                new ArgumentCompleter(
                        new StringsCompleter("load"),
                        new NullCompleter()
                ),
                new ArgumentCompleter(
                        new StringsCompleter("quit"),
                        new NullCompleter()
                ),
                new ArgumentCompleter(
                        new StringsCompleter("clear"),
                        new NullCompleter()
                ),
                new ArgumentCompleter(
                        new StringsCompleter("create"),
                        new StringsCompleter("class", "field", "method", "parameter"),
                        new NullCompleter()
                ),
                new ArgumentCompleter(
                        new StringsCompleter("create"),
                        new StringsCompleter("relationship"),
                        new StringsCompleter("AGGREGATION", "COMPOSITION", "INHERITANCE", "REALIZATION"),
                        new NullCompleter()
                ),
                new ArgumentCompleter(
                        new StringsCompleter("list"),
                        new StringsCompleter("classes", "relationships"),
                        new NullCompleter()
                )
        );
    }

    public AggregateCompleter updateCompleter(UMLModel classes) {
        // start with base completers
        Collection<Completer> completers = completer.getCompleters();
        completers = new ArrayList<>(completers);

        // array list to hold class names (to use for completer later)
        ArrayList<String> UMLclasses = new ArrayList<>();

        // array lists of enums
        //ArrayList<String> visTypes = new ArrayList<>(Arrays.asList("public", "private", "protected"));

        // loop through classes and create completers for fields/methods/parameters
        for (int i = 0; i < classes.getClasses().size(); ++i) {
            // get current class
            ClassObject currClass = classes.getClasses().get(i);
            String className = currClass.getName();
            // add to list of class names
            UMLclasses.add(className);

            // get fields for completer
            ArrayList<String> classFields = new ArrayList<>();
            for (Field f : currClass.getFields()) {
                classFields.add(f.getName());
                // add completer for setvis
                completers.add(
                        new ArgumentCompleter(
                                //new StringsCompleter("setvis"),
                                new StringsCompleter("field"),
                                new StringsCompleter(className),
                                new StringsCompleter(f.getName()),
                                //new StringsCompleter(visTypes),
                                new NullCompleter()
                        )
                );
                /*
                //add completer for settype
                completers.add(
                        new ArgumentCompleter(
                                //new StringsCompleter("settype"),
                                new StringsCompleter("field"),
                                new StringsCompleter(className),
                                new StringsCompleter(f.getName()),
                                new NullCompleter()
                        )
                );*/

                // add completers that deal with fields
                completers.add(
                        new ArgumentCompleter(
                                new StringsCompleter("delete", "rename"),
                                new StringsCompleter("field"),
                                new StringsCompleter(className),
                                new StringsCompleter(classFields),
                                new NullCompleter()
                        )
                );
            }

            // get methods for completer
            ArrayList<String> classMethods = new ArrayList<>();
            for (Method m : currClass.getMethods()) {
                classMethods.add(m.getName());
                // add completer for setvis
                completers.add(
                        new ArgumentCompleter(
                                new StringsCompleter("setvis"),
                                new StringsCompleter("method"),
                                new StringsCompleter(className),
                                new StringsCompleter(m.getName()),
                                //new StringsCompleter(visTypes),
                                new NullCompleter()
                        )
                );

                //add completer for settype
                completers.add(
                        new ArgumentCompleter(
                                new StringsCompleter("settype"),
                                new StringsCompleter("method"),
                                new StringsCompleter(className),
                                new StringsCompleter(m.getName()),
                                new NullCompleter()
                        )
                );

                // add completers for methods
                completers.add(
                        new ArgumentCompleter(
                                new StringsCompleter("delete", "rename"),
                                new StringsCompleter("method"),
                                new StringsCompleter(className),
                                new StringsCompleter(classMethods),
                                new NullCompleter()
                        )
                );

                // add completer for create parameter
                completers.add(
                        new ArgumentCompleter(
                                new StringsCompleter("create"),
                                new StringsCompleter("parameter"),
                                new StringsCompleter(className),
                                new StringsCompleter(m.getName()),
                                new NullCompleter()
                        )
                );

                //get parameters for completer
                ArrayList<String> parameters = new ArrayList<>();
                for (Parameter p : m.getParameters()) {
                    parameters.add(p.getName());
                    //add completer for settype
                    completers.add(
                            new ArgumentCompleter(
                                    new StringsCompleter("settype"),
                                    new StringsCompleter("parameter"),
                                    new StringsCompleter(className),
                                    new StringsCompleter(m.getName()),
                                    new StringsCompleter(p.getName()),
                                    new NullCompleter()
                            )
                    );
                }
                // add completer for method's parameters
                completers.add(
                        new ArgumentCompleter(
                                new StringsCompleter("rename", "delete"),
                                new StringsCompleter("parameter"),
                                new StringsCompleter(className),
                                new StringsCompleter(m.getName()),
                                new StringsCompleter(parameters),
                                new NullCompleter()
                        )
                );
            }

        }

        //add completer for tab completing classes for create/rename/delete
        completers.add(
                new ArgumentCompleter(
                        new StringsCompleter("rename", "delete"),
                        new StringsCompleter("class"),
                        new StringsCompleter(UMLclasses),
                        new NullCompleter()
                )
        );

        //add completer for creating fields/methods/parameters with existing class names
        completers.add(
                new ArgumentCompleter(
                        new StringsCompleter("create"),
                        new StringsCompleter("field", "method"),
                        new StringsCompleter(UMLclasses),
                        //new StringsCompleter(visTypes),
                        new NullCompleter()
                )
        );
        
        Map<String, Relationships> newMap = classes.getRelationships();
        ArrayList<Relationships> relArray = new ArrayList<Relationships>();
        for(String k : newMap.keySet()) {
        	relArray.add(newMap.get(k));
        }

        for(Relationships r : relArray) {
          //add completers for deleting a relationship
          completers.add(
              new ArgumentCompleter(
                  new StringsCompleter("delete"),
                  new StringsCompleter("relationship"),
                  new StringsCompleter(r.getID().toString()),
                  new StringsCompleter(r.getSource()),
                  new StringsCompleter(r.getDestination()),
                  new NullCompleter()
              )
          );
        }

        return new AggregateCompleter(completers);
    }
}
