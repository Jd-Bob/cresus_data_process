package mg.orange.cresus;

//import javax.enterprise.context.ApplicationScoped;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;

import javax.enterprise.context.ApplicationScoped;

//@ApplicationScoped
@QuarkusMain
public class MyApplication {
    public static void main(String[] args){
        System.out.println("Running MCS DATA PROCESS method");
        Quarkus.run(MyApp.class, args);
    }

    //Add class
    public static class MyApp implements QuarkusApplication {

        @Override
        public int run(String... args) throws Exception {
            System.out.println("Server UP");
            Quarkus.waitForExit();

            return 0;
        }
    }
}
