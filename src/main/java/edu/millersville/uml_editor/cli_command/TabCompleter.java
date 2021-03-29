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
                        new StringsCompleter("add"),
                        new StringsCompleter("class", "field", "method", "parameter"),
                        new NullCompleter()
                ),
                new ArgumentCompleter(
                        new StringsCompleter("add"),
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
        
        Collection<Completer> completers = completer.getCompleters();
        completers = new ArrayList<>(completers);

        ArrayList<String> UMLclasses = new ArrayList<>();

        Map<String, ClassObject> theClasses = classes.getClasses();
        
        for (String key : theClasses.keySet()) {
            ClassObject currClass = theClasses.get(key);
            UMLclasses.add(key);
            
            ArrayList<String> classFields = new ArrayList<>();
            for (Field f : currClass.getFields()) {
                classFields.add(f.getName());
                completers.add(
                        new ArgumentCompleter(
                                new StringsCompleter("field"),
                                new StringsCompleter(key),
                                new StringsCompleter(f.getName()),
                                new StringsCompleter("settype"),
                                new NullCompleter()
                        )
                );
                completers.add(
                        new ArgumentCompleter(
                                new StringsCompleter("delete", "rename"),
                                new StringsCompleter("field"),
                                new StringsCompleter(key),
                                new StringsCompleter(classFields),
                                new NullCompleter()
                        )
                );
            }

            ArrayList<String> classMethods = new ArrayList<>();
            for (Method m : currClass.getMethods()) {
                classMethods.add(m.getName());
                completers.add(
                        new ArgumentCompleter(  
                                new StringsCompleter("method"),
                                new StringsCompleter(key),
                                new StringsCompleter(m.getName()),
                                new StringsCompleter("settype"),
                                new NullCompleter()
                        )
                );
                completers.add(
                        new ArgumentCompleter(
                                new StringsCompleter("delete", "rename"),
                                new StringsCompleter("method"),
                                new StringsCompleter(key),
                                new StringsCompleter(classMethods),
                                new NullCompleter()
                        )
                );
                completers.add(
                        new ArgumentCompleter(
                                new StringsCompleter("add"),
                                new StringsCompleter("parameter"),
                                new StringsCompleter(key),
                                new StringsCompleter(m.getName()),
                                new StringsCompleter("settype"),
                                new NullCompleter()
                        )
                );
                ArrayList<String> parameters = new ArrayList<>();
                for (Parameter p : m.getParameters()) {
                    parameters.add(p.getName());
                    
                }
                completers.add(
                        new ArgumentCompleter(
                                new StringsCompleter("rename", "delete"),
                                new StringsCompleter("parameter"),
                                new StringsCompleter(key),
                                new StringsCompleter(m.getName()),
                                new StringsCompleter(parameters),
                                new NullCompleter()
                        )
                );
            }
        }
        completers.add(
                new ArgumentCompleter(
                        new StringsCompleter("rename", "delete"),
                        new StringsCompleter("class"),
                        new StringsCompleter(UMLclasses),
                        new NullCompleter()
                )
        );
        completers.add(
                new ArgumentCompleter(
                        new StringsCompleter("add"),
                        new StringsCompleter("field", "method"),
                        new StringsCompleter(UMLclasses),
                        new NullCompleter()
                )
        );
        
        Map<String, Relationships> newMap = classes.getRelationships();
        ArrayList<Relationships> relArray = new ArrayList<Relationships>();
        for(String k : newMap.keySet()) {
        	relArray.add(newMap.get(k));
        }

        for(Relationships r : relArray) {
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
