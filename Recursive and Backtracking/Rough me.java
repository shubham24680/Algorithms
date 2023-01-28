importjava.awt.Font;
importstaticjava.awt.Font.PLAIN;
importjava.awt.TextArea;
importjavax.crypto.Cipher;
importjavax.crypto.KeyGenerator;
importjava.crypto.Secretkey;
importjavax.swing.JButton;
importjavax.swing.JFrame;
importjavax.swing.JOptionPane;

public class Encrypter {
    static String decryptText="";
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(600,500);
        frame.setLocation(300,100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setResizable(false);

        Font font = new Font("ms gothic",PLAIN,30);
        TextArea ta = new TextArea();
        ta.setFont(font);
        ta.setBounds(0,0,500,400);
        frame.add(ta);
        JButton btn = new JButton("Encrypt");
        btn.setBounds(10,420,200,50);
        frame.add(btn);
        JButton decrypt = new JButton("Decrypt");
        decrypt.setBounds(240,420,200,50);
        frame.add(decrypt);

        frame.setVisible(true);

        btn.addActionListener((e) -> {
            try {
                KeyGenerator keygenerator = keyGenerator.getInstance("DES");
                SecretKey Key = Keygenerator.generateKey();

                Cipher desCipher;
                desCipher = Cipher.getInstance("DES");

                byte[] text = ta.getText().getBytes("UTF8");

                desCipher.init(Cipher.ENCRYPT_MODE, key);
                byte[] encryptedText = desCipher.doFinal(text);

                String str = new Srting(encryptedText);
                ta.setText(str);

                descipher.init(Cipher.DECRYPT_MODE, key);
                byte[] textdecrypted = desCipher.doFinal(encryptedText);

                decryptText = new String(textDecrypted);
                JOptionPane.showMessageDialog(btn, "Text encrypted");
                } catch (Exception ex) {
                    System.out.println(ex);
                }
              });

              decrypt.addActionListener((e)->{
                ta.setText(decryptText);
              });

            }

        }
            





