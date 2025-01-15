import algo.Key;
import algo.ShiftCipher.ShiftCipher;
import algo.SubstitutionCipher.SubstitutionCipher;
//import algo.IKey;
import algo.ShiftCipher.ShiftKey;
import algo.SubstitutionCipher.SubstitutionKey;

import java.awt.event.*;
import java.io.IOException;
import java.io.*;
import java.nio.file.Path;
import javax.swing.*;

public class EDCipherMain extends JFrame implements ActionListener {
//    static IKey key;
    static String keyString;
    static Path inputTextPath;
//    static String outputFile;
    static File outputFile;
    static ShiftCipher shiftCipher;
    static SubstitutionCipher substitutionCipher;

//    static JLabel l;

    EDCipherMain() {
    }

    public static void main(String[] args) throws IOException {

//        Path cypherTextPath = Path.of("IOFiles/cypherText.txt");

//        Path decodedPlainTextPath = Path.of("IOFiles/decodedPlainText.txt");
//
//        Files.createDirectories(cypherTextPath.getParent());
//        Files.createDirectories(plainTextPath.getParent());
//        Files.createDirectories(decodedPlainTextPath.getParent());
//
//        File cypherTextFile = new File(cypherTextPath.toString());
//        File decodedPlainTextFile = new File(decodedPlainTextPath.toString());
//
//        ShiftCypher sc = new ShiftCypher(10);
//        String cipherText = sc.encrypt(plainTextPath);
//        FileWriter cwr = new FileWriter(cypherTextFile);
//        cwr.write(cipherText);
//        cwr.flush();
//        cwr.close();
//
//        String decodedPlainText = sc.decrypt(cipherText);
//        FileWriter dwr = new FileWriter(decodedPlainTextFile);
//        dwr.write(decodedPlainText);
//        dwr.flush();
//        dwr.close();

//

        // Creating instance of JFrame
        JFrame frame = new JFrame();
//        EDCipherMain EDC = new EDCipherMain();
//        JPanel p = new JPanel();


//        JButton saveFileButton = new JButton("Save Input File");
//        saveFileButton.setBounds(250, 50, 150, 40);
//        saveFileButton.addActionListener(EDC);

        JFileChooser jfc = new JFileChooser(System.getProperty("user.dir"));

//        jfc.showSaveDialog(null);

        JButton openFileButton = new JButton("Open Input File");
        openFileButton.setBounds(450, 50, 150, 40);
        openFileButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (jfc.showOpenDialog(frame) != JFileChooser.APPROVE_OPTION) {
                    return;
                }

                inputTextPath = jfc.getSelectedFile().toPath();
            }
        });


//        l = new JLabel("no file selected");

        JTextField keyTextField = new JTextField();
        keyTextField.setBounds(350, 125, 150, 30);
        JLabel keyLabel = new JLabel("Key:");
        keyLabel.setBounds(310, 125, 50, 30);

        JTextField outputTextField = new JTextField();
        outputTextField.setBounds(350, 175, 150, 30);
        JLabel outputLabel = new JLabel("Output File Name:");
        outputLabel.setBounds(230, 175, 150, 30);


        JButton encryptButton = new JButton("Encrypt");
        encryptButton.setBounds(250, 450, 100, 40);

        JButton decryptButton = new JButton("Decrypt");
        decryptButton.setBounds(450, 450, 100, 40);

        DefaultListModel<String> l1 = new DefaultListModel<>();
        l1.addElement("Shift Cipher");
        l1.addElement("Substitution Cipher");
        JList<String> list = new JList<>(l1);
        list.setBounds(100,250, 175,150);


        encryptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(list.getSelectedIndex() != -1) {
                    try {
                        keyString = keyTextField.getText();
                    } catch (NumberFormatException nfe) {
                        throw new NumberFormatException("NumberFormatException occurred");
                    }
                    String cipherText;

                    switch(list.getSelectedValue()) {
                        case "Shift Cipher":
                            ShiftKey shiftKey = new ShiftKey();
                            shiftKey.setKey(keyString, "Shift Cipher");
                            shiftCipher = new ShiftCipher(shiftKey);
                            outputFile = new File(System.getProperty("user.dir") + "\\" + outputTextField.getText() + ".txt");
                            cipherText = shiftCipher.encrypt(inputTextPath);
                            break;
                        case "Substitution Cipher":
                            SubstitutionKey substitutionKey = new SubstitutionKey();
                            substitutionKey.setKey(keyString, "Substitution Cipher");
                            substitutionCipher = new SubstitutionCipher(substitutionKey);
                            outputFile = new File(System.getProperty("user.dir") + "\\" + outputTextField.getText() + ".txt");
                            cipherText = substitutionCipher.encrypt(inputTextPath);
                            break;
                        default:
                            throw new IllegalStateException("wrong selected cipher");
                    }

                    try {
                        FileWriter cwr = new FileWriter(outputFile);
                        cwr.write(cipherText);
                        cwr.flush();
                        cwr.close();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }

            }
        });

        decryptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(list.getSelectedIndex() != -1) {
                    try {
                        keyString = keyTextField.getText();
                    } catch (NumberFormatException nfe) {
                        throw new NumberFormatException("NumberFormatException occurred");
                    }
                    String plainText;

                    switch(list.getSelectedValue()) {
                        case "Shift Cipher":
                            ShiftKey shiftKey = new ShiftKey();
                            shiftKey.setKey(keyString, "Shift Cipher");
                            shiftCipher = new ShiftCipher(shiftKey);
                            outputFile = new File(System.getProperty("user.dir") + "\\" + outputTextField.getText() + ".txt");
                            plainText = shiftCipher.decrypt(inputTextPath);
                            break;
                        case "Substitution Cipher":
                            SubstitutionKey substitutionKey = new SubstitutionKey();
                            substitutionKey.setKey(keyString, "Substitution Cipher");
                            substitutionCipher = new SubstitutionCipher(substitutionKey);
                            outputFile = new File(System.getProperty("user.dir") + "\\" + outputTextField.getText() + ".txt");
                            plainText = substitutionCipher.decrypt(inputTextPath);
                            break;
                        default:
                            throw new IllegalStateException("wrong selected cipher");
                    }

                    try {
                        FileWriter dwr = new FileWriter(outputFile);
                        dwr.write(plainText);
                        dwr.flush();
                        dwr.close();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        });

//        frame.add(saveFileButton);
        frame.add(openFileButton);
        frame.add(keyTextField);
        frame.add(keyLabel);
        frame.add(outputTextField);
        frame.add(outputLabel);
        frame.add(encryptButton);
        frame.add(decryptButton);
        frame.add(list);
//        frame.show();

        frame.setSize(800, 600);
        frame.setLayout(null);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

