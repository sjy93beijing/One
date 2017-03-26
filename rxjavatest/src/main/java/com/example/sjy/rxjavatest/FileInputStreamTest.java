package com.example.sjy.rxjavatest;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by sjy_1993 on 2017/3/1.
 */
public class FileInputStreamTest {
    public static void main(String[] args) throws IOException {
//
//        try (   //将输入流InpustStream  转化为Reader对象 转成字符输入流
//                InputStreamReader reader = new InputStreamReader(System.in);
//                               //将普通的reader包装成BufferReader的U对象
//            BufferedReader br = new BufferedReader(reader);
//
//                ){
//            String line = null;
//            while ((line=br.readLine())!=null){
//                if(line.equals("exit")){
//                    System.exit(1);
//                }
//                                 System.out.print("输出内容："+line);
//            }
//
//        }   catch (IOException i)
//        {
//            i.printStackTrace();
//        }
//           }
//
//              }
//    创建字符
        try {


            FileReader fr = new FileReader("d:\\poem.txt");
            char[] buf = new char[20];
            int num = fr.read(buf);
            System.out.println("num" + num + new String(buf));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

//        int hasRead = 0;
//        while ((hasRead = fr.read(bbuf)) > 0)
//        //取出水滴，将字符数据转换为字符串输入
//        {
//            System.out.print(new String(bbuf, 0, hasRead));  //
//        }
//        fr.close();
//        try (FileWriter fw = new FileWriter("d:\\poem.txt",true)) {
//            fw.write("锦瑟-李商隐\r\n");
//            fw.write("庄生晓梦");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }
    }
}


