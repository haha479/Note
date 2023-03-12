package com.zhou;

import org.apache.hadoop.conf.Configuration;

import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;

import org.apache.hadoop.fs.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * 使用javaHDFS客户端对与远程HDFS中文件的操作
 */
public class HdfsClient {
    private FileSystem fs;

    @Before
    public void init() throws URISyntaxException, IOException, InterruptedException {
        //连接的集群nn地址
        URI uri = new URI("hdfs://hadoop102:8020");
        //创建一个配置文件
        Configuration configuration = new Configuration();
        //用户
        String user = "self479";
        //获取到客户端对象
        fs = FileSystem.get(uri, configuration, user);

    }

    @After
    public void close() throws IOException {
        //关闭资源
        fs.close();
    }

    //创建目录
    @Test
    public void testMkdir() throws IOException {
        //创建一个文件夹
        fs.mkdirs(new Path("/xiyou/huaguoshan"));
    }

    //上传
    @Test
    public void testPut() throws IOException {
        fs.copyFromLocalFile(true, false, new Path("D:\\sunwukong.txt"), new Path("hdfs://hadoop102/xiyou/huaguoshan"));
    }

    //下载
    @Test
    public void testGet() {
//        fs.copyToLocalFile();
    }

    //删除
    @Test
    public void testRm() {
//        fs.delete();
    }

    //获取文件详情
    @Test
    public void fileDetail() throws IOException {
        RemoteIterator<LocatedFileStatus> listFiles = fs.listFiles(new Path("/"), true);
        //循环遍历HDFS中根目录下的每个文件的详细信息
        while (listFiles.hasNext()) {
            LocatedFileStatus fileStatus = listFiles.next();
            System.out.println(fileStatus.getPath());
            System.out.println(fileStatus.getOwner());
            System.out.println(fileStatus.getGroup());
            System.out.println(fileStatus.getLen());
            System.out.println(fileStatus.getModificationTime());
            System.out.println(fileStatus.getReplication());
            System.out.println(fileStatus.getBlockSize());
            System.out.println(fileStatus.getPath().getName());

            //获取块信息：一个文件可能分成多个块，并且每个块可能有多个副本存储在不同节点中
            BlockLocation[] blockLocations = fileStatus.getBlockLocations();
            System.out.println(Arrays.toString(blockLocations));
        }
    }
    //
}
