# EnabledHandler
A simple utility to implement enabling and disabling into an object, such as a Module.

## Usage
```java
import wtf.monsoon.util.EnabledHandler;

public class Main {

    public static void main(String[] args) {
       Module superModule = new Module("Super Module!");

       superModule.setEnabled(false);

       if(superModule.isEnabled()) {
           System.out.println("Super Module is enabled!"); // Will not print, because it is not enabled.
       }

       superModule.setEnabled(true);

       if(superModule.isEnabled()) {
           System.out.println("Super Module is enabled!"); // This time, it will print, because it is now enabled.
       }
    }

    class Module extends EnabledHandler {

      private String name;

      public Module(String name) {
         this.name = name;
      }

    }
    
}
```
