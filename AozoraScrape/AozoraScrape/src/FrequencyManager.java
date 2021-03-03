
/**
 * Written by Lex Whalen
 */

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

//manages all frequency related things, like csv / graph creation

public class FrequencyManager
{
    //gets the frequency of each token in a work. Can be combined with
    //all works found, just be sure to make the inputted "tokenArr"
    //the combination of all the arrs you want.

    private List<Pair<String, String>> tokenPOSArr;
    private HashMap<String,Integer> freqHash = new HashMap<>();

    public FrequencyManager(List<Pair<String, String>> tokenPOSArr)
    {
        this.tokenPOSArr = tokenPOSArr;
        putInHashMap();
        sortHashMap();
    }

    private void putInHashMap()
    {
        //puts tokens in HM
        for(Pair pair:this.tokenPOSArr)
        {
            String token = pair.first.toString();
            String POS = pair.second.toString();

            String entry = String.format("%s,%s",token,POS);

            Integer count = this.freqHash.get(entry);
            if(count == null)
            {
                //if not already in, put a 1
                this.freqHash.put(entry,1);
            }
            else
            {
                //if already in, increment by 1
                this.freqHash.put(entry,count+1);
            }
        }
    }
    private void sortHashMap()
    {
        List<Map.Entry<String,Integer>> list = 
        new LinkedList<Map.Entry<String,Integer>>(this.freqHash.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String,Integer>>(){
            public int compare(Map.Entry<String,Integer> o1, Map.Entry<String,Integer> o2)
            
            {
                int i = o1.getValue().compareTo(o2.getValue());
                if(i!=0) return -i; // reverse sort
                return o1.getValue().compareTo(o2.getValue());
            }

        });
        //put data from sorted list into hm
        HashMap<String, Integer> temp = new LinkedHashMap<String,Integer>();

        for(Map.Entry<String,Integer> aa:list)
        {
            temp.put(aa.getKey(),aa.getValue());
        }
        this.freqHash = temp;
    }

    public void createCSV(String outCSVFileName)
    {
        String eol = System.getProperty("line.separator");
        try
        {
           try(Writer writer = new FileWriter(outCSVFileName+".csv"))
           {
               writer.append("token,pos,frequency");
               writer.append(eol);
               for(Map.Entry<String,Integer> entry: this.freqHash.entrySet())
               {
                   writer.append(entry.getKey())
                   .append(',')
                   .append((entry.getValue()).toString())
                   .append(eol);
               }
               
           }
        }
        catch(IOException ex)
        {
            ex.printStackTrace(System.err);
        }
    }

    public void printFreqHash(){
        for(String key: this.freqHash.keySet()){
            System.out.println(key + ":" + this.freqHash.get(key));
        }
    }

    public void printTokenArr(){
        for(int i=0;i<this.tokenPOSArr.size();i++){
            System.out.println(this.tokenPOSArr.get(i));
        }
    }
}
