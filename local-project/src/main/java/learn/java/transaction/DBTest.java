package learn.java.transaction;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBTest {
    private String url ;
    private String user;
    private String password;
    
    private volatile int trick = 1;

    /**
     * 创建数据连接
     * @return
     */
    private Connection getCon(){
        Connection con = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            url = "jdbc:mysql://192.168.4.100:3306/aicai_pay";
            user = "aicaitest";
            password = "T4Tf860yaH8TsfH";
            con = DriverManager.getConnection(url, user, password);
        }catch (Exception e){
            e.printStackTrace();
            try {
                con.close();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
        return con;
    }

    /**
     * 通过链接获取声明
     * @param con
     * @return
     */
    private Statement getStat(Connection con){
        Statement state = null;
        try{
            state = con.createStatement();
        }catch(Exception e){
            e.printStackTrace();
        }
        return state;
    }

    /**
     *  打印数据库所有数据
     */
    public void selectAll(int transactionType){
        Connection con = null;
        Statement state = null;
        ResultSet rs = null;
        try{
            con = getCon();
            if(transactionType >= 0 ){
                 con.setTransactionIsolation(transactionType);
            }
            System.out.println("-------------当前事务隔离级别为："+con.getTransactionIsolation()+"-------------");
            state = getStat(con);
            rs = state.executeQuery("select * from upstream_account");
            ResultSetMetaData rsmd = rs.getMetaData();
            for(int i = 1;i<= rsmd.getColumnCount() ;i++){
                System.out.print(rsmd.getColumnName(i)+"| ");
            }
            System.out.println();
            System.out.println("-------------------------------------------");
            //打印所有行
            while(rs.next()){
                for(int i = 1;i<= rsmd.getColumnCount() ;i++){
                    System.out.print(rs.getString(i)+"|     ");
                }
                System.out.println();
            }
        }
        catch (Exception e){
            try {
                con.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
        finally {
            try {
                if(rs != null){
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if(state != null){
                    state.close();
                }
            } catch (Exception e){

            }
            try {
                if(con != null){
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 新增一行
     * @param needExcepition
     * @param sleepTimes
     * @param values
     * @return
     */
    public int insertOne(int needExcepition,int sleepTimes, List<String> values){
        Connection con = getCon();
        PreparedStatement pre = null;
        String sql = "INSERT INTO `aicai_pay`.`upstream_account` (`chnl_acct_id`, `upstream_chnl_id`, `acct_no`) VALUES (?,?,?)";
       // String sql = "INSERT INTO flow (dict_type, dict_code, dict_name, dict_remark) VALUES (?, ?, ?, ?)";
        int res = 0;
        try {
            con.setAutoCommit(false);
            pre = con.prepareStatement(sql);
            trick = trick + 1;
            for(int i = 0; i < values.size() ;i++){
                pre.setString(i+1, values.get(i)+trick);
            }
            Thread.sleep(sleepTimes);
            System.out.println("insert before execute");
            res = pre.executeUpdate();
            System.out.println("insert after execute");
            Thread.sleep(sleepTimes);
            int i = 1/needExcepition;
            System.out.println("insert before commit");
            con.commit();
            System.out.println("insert after commit");
        } catch (Exception e) {
            try {
                System.out.println("insert before roll back");
                con.rollback();
                System.out.println("insert after roll back");
                res = 0;
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            System.out.println("-----exception happend--------");
            // e.printStackTrace();
        } finally {
            try {
                if(pre != null){
                    pre.close();
                }
            } catch (Exception e){

            }
            try {
                if(con != null){
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return res;
    }

    /**
     * 间隔一定时间读取多次
     * @param dictType 要去读取的数据类型
     * @param sleepTimes 每次读取之间的间隔时间
     * @param printTimes 打印次数
     * @param transactionType 事务隔离级别
     */
    private void printMultiple(String dictType,int sleepTimes,int printTimes, int transactionType){
        Connection con = null;
        Statement state = null;
        ResultSet rs = null;
        try{
            con = getCon();
            con.setAutoCommit(false);
            if(transactionType >= 0){
                con.setTransactionIsolation(transactionType);
            }
            System.out.println("-------------当前事务隔离级别为："+con.getTransactionIsolation()+"-------------");
            state = getStat(con);
            for (int j = 0; j < printTimes; j++) {
                Thread.sleep(sleepTimes);
                // rs = state.executeQuery("select * from upstream_account where chnl_acct_id = '"+dictType+"' ");
                rs = state.executeQuery("select * from upstream_account ");
                ResultSetMetaData rsmd = rs.getMetaData();
                System.out.println("第"+(j+1)+"次读取");
                for(int i = 1;i<= rsmd.getColumnCount() ;i++){
                    System.out.print(rsmd.getColumnName(i)+"| ");
                }
                System.out.println();
                System.out.println("-------------------------------------------");
                while(rs.next()){
                    for(int i = 1;i<= rsmd.getColumnCount() ;i++){
                        System.out.print(rs.getString(i)+"|     ");
                    }
                    System.out.println();
                }   
            }
            con.commit();
        }
        catch (Exception e){
            try {
                con.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
        finally {
            try {
                if(rs != null){
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if(state != null){
                    state.close();
                }
            } catch (Exception e){

            }
            try {
                if(con != null){
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 更改一条数据的内容
     * @param dict_type
     * @param sleepTimes
     * @param values
     * @return
     */
    public int updateOne(String chnl_acct_id,int sleepTimes, List<String> values){
        Connection con = null;
        PreparedStatement pre = null;
        String sql = "UPDATE upstream_account  SET upstream_chnl_id = ? WHERE chnl_acct_id ='"+chnl_acct_id+"'";
        int res = 0;
        try {
            con = getCon();
            con.setAutoCommit(false);
            con.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
            pre = con.prepareStatement(sql);
            for(int i = 0; i < values.size() ;i++){
                pre.setString(i+1, values.get(i));
            }
            Thread.sleep(sleepTimes);
            System.out.println("update before execute ");
            res = pre.executeUpdate();
            System.out.println("update after execute ");
            Thread.sleep(sleepTimes);
            System.out.println("update before commit");
            con.commit();
            System.out.println("update after commit");
        } catch (Exception e) {
            try {
                con.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                if(pre != null){
                    pre.close();
                }
            } catch (Exception e){

            }
            try {
                if(con != null){
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return res;
    }

    /**
     * @param transType
     */
    public void testTransaction(int transType){
        intDate();
        System.out.println("-------------------读脏模拟---------------------");
        testDirty(transType);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("-------------------重读模拟--------------------");
        testRepeat(transType);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("-------------------幻读模拟--------------------");
        testTrick(transType);
    }

    /**
     * 初始化数据
     */
    private void intDate(){
        System.out.println("------------初始化数据 start-------------");
        Connection con = getCon();
        Statement pre = null;
        String sqlDelete = "delete from upstream_account";
        String sqlInsert = "INSERT INTO `aicai_pay`.`upstream_account` (`chnl_acct_id`, `upstream_chnl_id`, `acct_no`, `asset_mng`,`create_time`,`modify_time`) VALUES ('1', '2', '3', '4','2018-03-01','2018-03-01')";
        try {
            con.setAutoCommit(false);
            pre = con.createStatement();
            pre.execute(sqlDelete);
            pre.execute(sqlInsert);
            con.commit();
        } catch (Exception e) {
            try {
                con.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                if(pre != null){
                    pre.close();
                }
            } catch (Exception e){
                e.printStackTrace();
            }
            try {
                if(con != null){
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        System.out.println("------------初始化数据 end-------------");
    }
    /**
     * 模拟读脏，抛出未捕获异常，插入数据不提交
     */
    public void testDirty(int transactionType){
        List<String> list = new ArrayList<String>();
        list.add("2");
        list.add("2");
        list.add("2");
        TestThread testThread = new TestThread("insert",0,300,list);
        Thread thread = new Thread(testThread);
        thread.start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        selectAll(transactionType);
    }

    /**
     * 模拟幻读，第N次读取多出数据
     */
    public void testTrick(int transactionType){
        List<String> list = new ArrayList<String>();
        list.add("2");
        list.add("2");
        list.add("2");
        //执行插入，不产生异常
        TestThread testThread = new TestThread("insert",1,400,list);
        Thread thread = new Thread(testThread);
        thread.start();
        //打印两次
        printMultiple("22", 300,4,transactionType);
    }

    /**
     * 模拟不可重读，多次读取同一条记录，记录被更改
     */
    public void testRepeat(int transactionType){
        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("111");
        //执行插入，不产生异常
        TestThread testThread = new TestThread("update",1,400,list);
        Thread thread = new Thread(testThread);
        thread.start();
        //打印4次
        printMultiple("1", 300,4,transactionType);
    }

    public static void main(String[] args){
        DBTest dbTest = new DBTest();
        /*分别执行下面的方法，即可模拟各个隔离级别下，线程并发事务间的访问结果*/
        // System.out.println(" -----------------------TRANSACTION_READ_UNCOMMITTED test start------------------------");
        // dbTest.testTransaction(Connection.TRANSACTION_READ_UNCOMMITTED);

        // System.out.println(" -----------------------TRANSACTION_READ_COMMITTED test start------------------------");
        //   dbTest.testTransaction(Connection.TRANSACTION_READ_COMMITTED);
     
       // System.out.println(" -----------------------TRANSACTION_REPEATABLE_READ test start------------------------");
      	// dbTest.testTransaction(Connection.TRANSACTION_REPEATABLE_READ);
      
      // System.out.println(" -----------------------TRANSACTION_SERIALIZABLE test start------------------------");
      // dbTest.testTransaction(Connection.TRANSACTION_SERIALIZABLE);
//      
//      System.out.println(" -----------------------default test start------------------------");
        dbTest.testTransaction(0);
    }

}   