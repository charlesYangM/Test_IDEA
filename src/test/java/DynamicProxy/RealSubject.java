package DynamicProxy;

import DynamicProxy.Subject;

public class RealSubject implements Subject {
    @Override
    public void Request() {
// TODO Auto-generated method stub
        System.out.println("Yang");
    }
}