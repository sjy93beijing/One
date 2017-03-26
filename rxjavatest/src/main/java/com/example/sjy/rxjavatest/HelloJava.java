package com.example.sjy.rxjavatest;

import java.io.FileWriter;
import java.io.IOException;

/**
 * 字节流抽象基类：InputStream    OutputStream
 * 字符流抽象基类 ： Reader   Writer
 *
 * 你可以这样理解：字符比字节要大，也就是分别用这两流时，都作为最小的单位。
 字节可以处理任何数据类型，字符要比字节能处理的类型要少。
 通常在处理文本时优先使用字符流，其他的用字节流
 在读写文件需要对内容按行处理，比如比较特定字符，处理某一行数据的时候一般会选择字符流。
 只是读写文件，和文件内容无关的，一般选择字节流。
 * 按操作：字节流，字符流
 * 按流向：输入流，输出流
 * Created by sjy_1993 on 2017/3/1.
 */
//需求，在硬盘上创建文件，并写入数据
public class HelloJava {
   public static void main(String[] args){
       try {
           FileWriter fileWriter = new FileWriter("test.txt");
           //写入数据到内存里
           fileWriter.write("adadada");
           //刷新流
           fileWriter.flush();
           fileWriter.close();//关闭流


       }catch (IOException e)
       {
           e.printStackTrace();
       }
    }
}
