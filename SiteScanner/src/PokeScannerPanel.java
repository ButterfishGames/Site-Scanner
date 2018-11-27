import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;

public class PokeScannerPanel extends JPanel
{
    private String url, outCode;
    private JPanel in, out;
    private JLabel label;
    private JButton run;
    private JTextField input, output;
    
    public PokeScannerPanel()
    {
        setLayout(new BorderLayout());
        
        url = "https://bulbapedia.bulbagarden.net/wiki/";
        outCode = "";
        
        label = new JLabel("Pokemon: ");
        
        run = new JButton("Run");
        run.addActionListener(new RunListener());
        
        input = new JTextField();
        input.setPreferredSize(new Dimension(100, 20));
        output = new JTextField();
        output.setPreferredSize(new Dimension(500, 500));
        
        in = new JPanel();
        in.add(label);
        in.add(input);
        in.add(run);
        add(in, BorderLayout.NORTH);
        
        out = new JPanel();
        out.add(output);
        add(out, BorderLayout.SOUTH);
    }
    
    private class RunListener implements ActionListener
    {
        public void actionPerformed (ActionEvent event)
        {
            String inName, outName;
            
            inName = input.getText();
            outName = "";
            
            for (int i = 0; i < inName.length(); i++)
            {
                if (i == 0)
                {
                    outName = ("" + inName.charAt(i)).toUpperCase();
                }
                else
                {
                    outName += ("" + inName.charAt(i)).toLowerCase();
                }
            }
            
            url += outName + "_(Pokémon)";
            
            try
            {
                Document document = Jsoup.connect(url).get();
                
            }
            catch (Exception e)
            {
                System.out.print(e);
            }
            output.setText(outCode);
        }
    }
}
