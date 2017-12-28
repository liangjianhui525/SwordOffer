package nuike.haiwei;

import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by Administrator on 2017/8/16.
 */
public class CoutErrFile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedHashMap<String,Integer> map = new LinkedHashMap<>();
        while (sc.hasNext()){
            String filePath = sc.next();
            int lineNumber = sc.nextInt();
            String[] filePaths = filePath.split("\\");
            String fileName = filePaths[filePaths.length-1];
            if(fileName.length()>16){
                fileName = fileName.substring(fileName.length()-16);
            }
            StringBuffer sb = new StringBuffer();
            fileName = sb.append(fileName).append(" ").append(lineNumber).append(" ").toString();
            if(map.containsKey(sb.toString())){
                map.put(fileName,map.get(fileName)+1);
            }else {
                map.put(fileName,1);
            }
        }
        Set<String> set = map.keySet();
        int cout = 0 ;
        for(String i : set){
            cout++;
            if(cout>(map.size()-8)){
                System.out.println(i+map.get(i));
            }
        }
    }
}
