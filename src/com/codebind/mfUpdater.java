package com.codebind;

import javax.print.DocFlavor;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.io.*;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.net.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class mfUpdater {
    private static String URL2DOWNLOAD;
    private JProgressBar pBar;
    private JPanel mainPanel;
    private JButton button1;
    private static List<String> DownloadFiles = new ArrayList<String>();


    public mfUpdater() {
      // button1.addActionListener(new ActionListener() {
      //     @Override
      //     public void actionPerformed(ActionEvent e) {
      //         JOptionPane.showMessageDialog(null, "Hello world");
      //     }
       // });
    mainPanel.addComponentListener(new ComponentAdapter() { } );}

    public static void main(String[] args){
        JFrame frame = new JFrame("mfUpdater");
        frame.setContentPane(new mfUpdater().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        Init(args);

    }

    public static void download() {

        if (Files.exists(Paths.get("link.txt"))) {
            try {
                DownloadFiles = Files.readAllLines(Paths.get("link.txt"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    protected  static void Init(String[] args)
    {
        if(args.length != 0) {
            for (var arg : args) {
                var input = arg.substring(1);

                switch (input)
                {
                    case "link" :
                        URL2DOWNLOAD = input;
                        try {
                            Files.copy(
                                    new URL("URL2DOWNLOAD").openStream(),
                                    Paths.get("link.txt"));
                            //URL url3 = new URL("http", "www.gnu.org", "/licenses/gpl.txt");
                        }
                        catch (Exception ex) {};
                        break;
                    default: break;
                }
            }
        }
    }


}
