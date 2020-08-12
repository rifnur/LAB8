import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Form extends JFrame {
    JTextField txt1 = null;
    Double res = 0.0;
    //int res1 = 0;
    String op = "";
    public Form(String title) {
        setTitle(title);
        setBounds(50, 30, 300, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBackground(new Color(100, 232,214));

        setLayout(new GridLayout(2, 1));

        JTextField inputField = new JTextField();
        inputField.setEditable(false);

        ButtonListener buttonListener = new ButtonListener(inputField);

        JPanel buttonPanel = new JPanel(new GridLayout(5, 3));

        for (int i = 0; i <= 9; i++) {
            JButton digit = new JButton(String.valueOf(i));
            digit.addActionListener(buttonListener);
            buttonPanel.add(digit);
        }

        JButton plus = new JButton("+");
       //plus.addActionListener(buttonListener);
       plus.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent arg1)
            {
               res= Double.valueOf(inputField.getText());
                inputField.setText("");
                op = "+";
            }
        });
        JButton minus = new JButton("-");
       // minus.addActionListener(buttonListener);
        minus.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent arg1)
            {
                res=Double.valueOf(inputField.getText());
                inputField.setText("");
                op = "-";
            }
        });
        JButton multiple = new JButton("*");
        //multiple.addActionListener(buttonListener);
        multiple.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent arg1)
            {
                res=Double.valueOf(inputField.getText());
                inputField.setText("");
                op = "*";
            }
        });

        JButton clear = new JButton("C");
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputField.setText("");
            }
        });
        JButton divided = new JButton("/");
        divided.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent arg1)
            {
                res=Double.valueOf(inputField.getText());
                inputField.setText("");
                op = "/";
            }
        });

        buttonPanel.add(plus);
        buttonPanel.add(minus);
        buttonPanel.add(multiple);
        buttonPanel.add(clear);
        buttonPanel.add(divided);

        add(buttonPanel);

        JPanel inputPanel = new JPanel(new BorderLayout());
        JButton submit = new JButton("Submit");
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int secondValue = Integer.valueOf(inputField.getText());
                if("+".equals(op)){
                    inputField.setText(( res+secondValue)+"");
                }
                if("-".equals(op)){
                    inputField.setText((res-secondValue)+"");
                }
                if("*".equals(op)){
                    inputField.setText((res*secondValue)+"");
                }
                if("/".equals(op)){
                    inputField.setText((res/secondValue)+"");
                }
                res = 0.0;
                op = "+";
            }
        });

        inputPanel.add(inputField, BorderLayout.CENTER);
        inputPanel.add(submit, BorderLayout.EAST);

        add(inputPanel);

        setVisible(true);
    }
}