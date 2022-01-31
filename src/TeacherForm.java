import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TeacherForm {
    public JPanel getPanel1() {
        return panel1;


    }
    public TeacherForm(JFrame owner){
        this.owner= owner;
        cursuriButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] list = new String[Application.getInstance().manager.getCursuri().size()];
                for (String s : Application.getInstance().currentUser.menuStrategy.getAccountHolderInformation().keySet()) {
                    String prenume = Application.getInstance().currentUser.menuStrategy.getAccountHolderInformation().get(s);
                    int nr = 0;

                    for (Curs c : Application.getInstance().manager.getCursuri()) {
                        if (c.profu.nume.equals(s) && c.profu.prenume.equals(prenume)) {
                            list[nr++] = c.nume;
                        }
                    }

                }
                    list1.setListData(list);

            }
        });
        studentiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(list1.getSelectedIndex() != -1 ){
                    String numecurs = (String) list1.getSelectedValue();
                    int nr=0;

                    for (Curs c : Application.getInstance().manager.getCursuri())
                    {
                        String [] lista = new String[c.studenti.size()];

                               if(c.equals(new Curs(numecurs) ))
                               {
                                   for (Student s : c.studenti)
                                   {
                                       lista[nr++] = s.nume+ " " + s.prenume + " " + c.nota.get(s) ;
                                   }
                                   list2.setListData(lista);

                               }

                    }

                }

            }
        });
        noteazaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(list1.getSelectedIndex() != -1 && list2.getSelectedIndex() != -1 && textField1.getText() != null){
                    String data = (String) list2.getSelectedValue();
                    String numecurs = (String)  list1.getSelectedValue();
                    for (Curs c : Application.getInstance().manager.getCursuri())
                    {
                        if(c.equals(new Curs(numecurs) )){
                            try {
                                c.noteazaStudent(new Student(data.split(" "   ) [0],data.split(" ")[1] ),Integer.parseInt(textField1.getText()) );


                               Application.getInstance().display.displayCourses(Application.getInstance().manager.getCursuriArray());
                                int nr=0;

                                for (Curs curs : Application.getInstance().manager.getCursuri())
                                {
                                    String [] lista = new String[curs.studenti.size()];

                                    if(curs.equals(new Curs(numecurs) ))
                                    {
                                        for (Student s : curs.studenti)
                                        {
                                            lista[nr++] = s.nume+ " " + s.prenume + " " + curs.nota.get(s) ;
                                        }
                                        list2.setListData(lista);

                                    }

                                }


                            }
                            catch (Exception ex ){
                                JOptionPane.showMessageDialog(null , ex.getMessage());
                            }
                        }
                    }
                }
            }
        });

        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel1.setVisible(false);
             owner.setContentPane(new LoginForm(owner) .getMainPanel());
            }
        });
    }

    private JPanel panel1;
    private JButton cursuriButton;
    private JButton studentiButton;
    private JList list1;
    private JList list2;
    private JTextField textField1;
    private JButton noteazaButton;
    private JButton logoutButton;
    private JFrame owner;
}
