import java.util.*;

public class Class {

    private Map<String, String[]> theClass;
    private String className;
    private String[] attribute;
    private String element;
    //public Scanner console = new Scanner(System.in);

    public Class(String name, String[] attr){
        className = name;
        attribute = attr;
        theClass = new HashMap<String, String[]>();
    }
    public Class(String name) {
        className = name;
    }

    public void createNewClass(String className, String[] attribute) {
        theClass.put(className, attribute);
    }

    public void addNewAttribute(String name, String[] attribute, String element) {

    }

}
