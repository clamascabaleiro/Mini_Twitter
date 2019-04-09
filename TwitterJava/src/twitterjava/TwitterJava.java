

package twitterjava;

import java.util.*;
import javax.swing.*;
import twitter4j.*;


/**
 *
 * @author clamascabaleiro
 */
public class TwitterJava {
int opcion;

        // TODO code application logic here
      public static void main(String[] args) throws TwitterException {
        // TODO code application logic here
        int opcion;
        Twitter twitter = TwitterFactory.getSingleton();
        do{
            opcion = Integer.parseInt(JOptionPane.showInputDialog("App Twitter"
                    + "\n1. Realizar un tuit\n2. Mostrar la línea del tiempo"
                    + "\n3. Filtrar\n4. Salir"));
            switch(opcion){
                //Realizar un tuit
                case 1: String tuit = JOptionPane.showInputDialog("Introduzca un tuit:");
                Status st = twitter.updateStatus(tuit);
                JOptionPane.showMessageDialog(null, "Realizado correctamente el tuit [" + st.getText() + "].");
                break;
                //Mostrar la línea de tiempo
                case 2: List<Status> statuses = twitter.getHomeTimeline();
                System.out.println("Mostrando la línea de tiempo:");
                for (Status status : statuses) {
                    System.out.println(status.getUser().getName() + ":" + status.getText());
                }
                break;
                //Filtrado
                case 3: String busqueda = JOptionPane.showInputDialog("Introduzca palabra de búsqueda:");
                Query query = new Query(busqueda);
                QueryResult result = twitter.search(query);
                for (Status status : result.getTweets()) {
                    System.out.println("@" + status.getUser().getScreenName() + ":" + status.getText());
                }
                break;
                case 4: System.exit(0);
            }
        }while(opcion!=4);
        
    }
        
}
    

    



