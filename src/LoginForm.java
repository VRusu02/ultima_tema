import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class LoginForm {
   public LoginForm(JFrame owner, ArrayList<Profesor> profesori, ArrayList<Student> studenti) {
 //  public LoginForm(JFrame owner) {
        this.owner = owner;
       // this.studenti = studenti;
       // this.profesori = profesori;
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ( e.getSource() == btnLogin) {
                    System.out.println("Am apasat butonul de login");
                    try {
                        Application.getInstance().login(new User(txtUsername.getText(), new String(txtPassword.getPassword())));
                        JOptionPane.showMessageDialog(null, "Login successfully!");
                   //     mainPanel.setVisible(false);
                        panel2.setVisible(false);
                        if(Application.getInstance().currentUser.menuStrategy.getAccountType().toString().compareTo("TEACHER") == 0)
                            owner.setContentPane(new TeacherForm(owner).getPanel1());
                        else
                            owner.setContentPane(new StudentForm(owner).getPanel2());

                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                    }




                }
            }
        });

       btnRegister.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               panel2.setVisible(false);
               owner.setContentPane(new RegisterForm(owner).getRegisterPanel());
           }
       });
   }

    public LoginForm(JFrame main) {

    }


    public JPanel getMainPanel() {
        return panel2;
    }

    private JPanel panel2;
    private JLabel lblUsername;
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JButton btnLogin;
    private JButton btnRegister;
    private JLabel lblPassword;
    private JFrame owner;
    public static ArrayList<Student> studenti;
    public static ArrayList<Profesor> profesori;



}

