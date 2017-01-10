package com.swpu.socket.impl;



import com.swpu.socket.InfoItem;
import com.swpu.utils.GsonUtils;



import java.io.*;
import java.net.Socket;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Author: wuhaojie
 * E-mail: w19961009@126.com
 * Date: 2016/7/5 14:46
 * Version: 1.0
 */

public class NodeDataOpt  implements Runnable  {

    private Socket mSocket;
    private OutputStream mOutputStream;
    private InputStream mInputStream;
    private boolean canRunning = true;

    public NodeDataOpt(Socket socket) {
        mSocket = socket;
    }




    @Override
    public void run() {
        try {
            mInputStream = mSocket.getInputStream();
            mOutputStream = mSocket.getOutputStream();
        } catch (IOException e) {
            System.out.println("连接失败");
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(mInputStream));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(mOutputStream));
        System.out.println("连接成功");

        new SendThread(writer).start();
        List<InfoItem> infoItemList = new ArrayList<>();

        while (canRunning) {
            try {
                // 读取一行数据
                String line = reader.readLine();
                InfoItem item = GsonUtils.fromJson(line, InfoItem.class);
                infoItemList.add(item);
                if (item != null)
                    System.out.println(item.toString());

                // 存入数据库
                if(infoItemList.size()>=3){
                    insert2DataBase(infoItemList);
                    infoItemList.clear();
                }



            } catch (IOException e) {
                System.out.println("读取失败");
                canRunning = false;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }



    private void insert2DataBase(List<InfoItem> infoItemList) throws SQLException {
        Connection con = null;//定义一个MYSQL链接对象
        PreparedStatement ps = null; //创建声明
        String sql = "INSERT INTO information VALUES (NULL ,?,?,?,?,?,?,?,?)";
        try {
            Class.forName("com.mysql.jdbc.Driver"); //MYSQL驱动
            con = DriverManager.getConnection(
                    "jdbc:mysql://139.199.7.26:3306/AISystemServer",
                    "root", "PW324-mysql");
            ps = con.prepareStatement(sql);
            for (InfoItem item:  infoItemList
                 ) {
                ps.setInt(1, item.getMLightState());
                ps.setInt(2, item.getMPumpState());
                ps.setInt(3, item.getMFanState());
                ps.setInt(4, item.getMAirMoisture());
                ps.setInt(5, item.getMAirTemperature());
                ps.setInt(6, item.getMLightIntensity());
                ps.setInt(7, item.getMSoilMoisture());
                ps.setInt(8, item.getMSoilTemperature());
                ps.executeUpdate();
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                    ps = null;
                }
                if (con != null) {
                    con.close();
                    con = null;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
