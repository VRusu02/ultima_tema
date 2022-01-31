import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class RegisterForm    {


    private JButton btnRegister;
    private JButton btnCancel;
    private JPanel registerPanel;
    private JTextField tfNume;
    private JTextField tfPrenume;
    private JPasswordField pfPassword;
    private JPasswordField pfCPassword;
    private JTextField tfUsername;
    private JFrame main;

    public RegisterForm(JFrame main) {
        this.main=main;
        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (tfNume.getText()!= null && tfPrenume.getText() != null&& tfUsername.getText()!= null && pfPassword.getPassword() != null && pfCPassword.getPassword()!= null ){
                    if(new String(pfPassword.getPassword()).equals(new String(pfCPassword.getPassword()))){
                        if (LoginForm.studenti.indexOf(new Student(tfNume.getText(),tfPrenume.getText()))  != -1){
                            MenuStrategy menuStrategy = new StudentStrategy(new Student(tfNume.getText(),tfPrenume.getText()) );
                            Application.getInstance().saveUsers(new User(tfUsername.getText(), new String(pfPassword.getPassword()) ,menuStrategy) );

                        }
                        if (LoginForm.profesori.indexOf(new Profesor(tfNume.getText(), tfPrenume.getText()  ) )  != -1 ){
                            MenuStrategy menuStrategy = new TeacherStrategy(new Profesor(tfNume.getText(),tfPrenume.getText()) );
                            Application.getInstance().saveUsers(new User(tfUsername.getText(), new String(pfPassword.getPassword()) ,menuStrategy) );
                        }
                    }
                }
            }
        });
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registerPanel.setVisible(false);
                main.setContentPane(new LoginForm(main).getMainPanel());

            }
        });
    }


    public JPanel getRegisterPanel() {
        return registerPanel;
    }




}

