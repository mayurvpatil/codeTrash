import java. util.*;
import java. lang.*;
class HackClass<T> 
{
T hackobj;
HackClass(T hackobj) { this.hackobj = hackobj; }
public T hackfunc() {
return this. hackobj; }
}


public class Main {
    

    public static void main(String[] args) {
        HackClass<Integer > h1 = new HackClass<Integer>(15);
        System.out.println(h1.hackfunc());

        HackClass<String > h2 = new HackClass<String>("asdf");
        System.out.println(h2.hackfunc());

    }
}