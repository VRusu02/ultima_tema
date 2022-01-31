import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentForm {
  public JPanel getPanel2()
  {
    return panel2;
  }

public  StudentForm (JFrame owner) {
      this.owner = owner;
    cursuriButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String[] lista = new String[Application.getInstance().manager.getCursuri().size()];
            for (String s : Application.getInstance().currentUser.menuStrategy.getAccountHolderInformation().keySet()) {
                String prenume = Application.getInstance().currentUser.menuStrategy.getAccountHolderInformation().get(s);
                int nr = 0;

                for (Curs c : Application.getInstance().manager.getCursuri()) {

                    for (Student student : c.studenti) {
                        if (student.equals(new Student(s, prenume))) {
                            lista[nr++] = c.nume + " " + c.nota.get(s);
                        }
                    }
                }

            }
            list1.setListData(lista);

        }

    });

    logoutButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            panel2.setVisible(false);
            owner.setContentPane(new LoginForm(owner).getMainPanel());
        }
    });
}


  private JPanel panel2;
  private JButton cursuriButton;
  private JButton mediaButton;
  private JList list1;
    private JButton logoutButton;
    private JFrame owner;
}



//public class StudentForm {
  //  private JPanel Panel2;
 //   private JTextField textField1;
   // private JTextField textField2;
//  private JPanel panel2;

   // public JPanel getPanel2() {
    //    return panel2;
   // }


//}