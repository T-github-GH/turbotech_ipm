package panels;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Receivepanel extends JPanel {
    private final String BTN_DIR = "Dir";
    private final String BTN_FILE = "File";

    private static JLabel addressTextFile;
    private static JTextField txtFile;
    private static JTextField txtDir;
    private Font textFieldFont = new Font(Font.SERIF, Font.PLAIN, 30);
    private Font textLabelFont = new Font(Font.SERIF, Font.BOLD, 40);
    private Font btnFont = new Font(Font.SERIF, Font.BOLD, 34);

    private File selectedFile;
    public Receivepanel() {

        JPanel ptitle = new JPanel();
        JLabel title = new JLabel("Upload Files: ");
        title.setFont( new Font(Font.SERIF, Font.BOLD, 80) );
        ptitle.setLayout(new BorderLayout());
        ptitle.add(title, BorderLayout.WEST);
        ptitle.setMaximumSize(new Dimension(10000, 100));

        JPanel p = new JPanel();
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();
        DropPane dropPane = new DropPane();

        JLabel addressTextDir = new JLabel("Directory Address: ");
        addressTextDir.setFont( textLabelFont );
        JButton btnDir = new JButton("Select");
        txtDir = new JTextField();
        txtDir.setFont(textFieldFont);

        addressTextFile = new JLabel("File Address: ");
        addressTextFile.setFont( textLabelFont );
        JButton btnFile = new JButton("Select");
        txtFile = new JTextField();
        txtFile.setFont(textFieldFont);


        Dimension dimension = new Dimension(180,80);
        btnDir.setMaximumSize(dimension);
        btnDir.setMinimumSize(dimension);
        btnDir.setFont( btnFont );
        btnFile.setMaximumSize(dimension);
        btnFile.setMinimumSize(dimension);
        btnFile.setFont( btnFont );
        btnActionListener(btnFile, this.BTN_FILE);

        p1.add(addressTextDir);
        p1.add(addressTextFile);
        p2.add(txtDir);
        p2.add(txtFile);
        p3.add(btnDir);
        p3.add(btnFile);

        BoxLayout p1Layout = new BoxLayout(p1, BoxLayout.Y_AXIS);
        BoxLayout p2Layout = new BoxLayout(p2, BoxLayout.Y_AXIS);
        BoxLayout p3Layout = new BoxLayout(p3, BoxLayout.Y_AXIS);
        p1.setLayout(p1Layout);
        p2.setLayout(p2Layout);
        p3.setLayout(p3Layout);

        p.add(p1);
        p.add(p2);
        p.add(p3);
        p.setMaximumSize(new Dimension(1500,80));
        p.setMinimumSize(new Dimension(1000,80));
        p.setLayout(new BoxLayout(p, BoxLayout.X_AXIS));

        JButton btnStart = new JButton("Start");
        btnStart.setFont(new Font(Font.DIALOG, Font.BOLD, 40));
        btnStart.setMaximumSize(dimension);

        JPanel footer = new JPanel();
        footer.setLayout(new BorderLayout());
        footer.add(btnStart, BorderLayout.CENTER);
        footer.add(Box.createRigidArea(dimension), BorderLayout.SOUTH);
        footer.add(Box.createRigidArea(dimension), BorderLayout.NORTH);
        footer.setMinimumSize(dimension);
        footer.setMaximumSize(dimension);

        add(ptitle);
        add(p);
        add(dropPane);
        add(footer);

        BoxLayout boxLayout = new BoxLayout(this, BoxLayout.Y_AXIS);
        setLayout(boxLayout);
    }

    private void btnActionListener (JButton btn,String type){
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
                jfc.setDialogTitle("Choose a directory to save your file: ");
                jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                int returnValue = jfc.showSaveDialog(null);
            }
        });
    }
    public static void setAddressTextFile (String str){
        txtFile.setText(str);
    }
}