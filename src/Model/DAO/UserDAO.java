package Model.DAO;

import Connection.ConnectionFactory;
import Model.User;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserDAO {

    public void create(User u) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            
            stmt = con.prepareStatement(
                "INSERT INTO users_tb(user_name, user_username, user_email, user_phone, user_password) VALUES (?,?,?,?,?)"
            );
        
            stmt.setString(1, u.getName());
            stmt.setString(2, u.getUsername());
            stmt.setString(3, u.getEmail());
            stmt.setString(4, u.getPhone());
            stmt.setString(5, u.getPassword());
            stmt.executeUpdate();
            
        } catch (SQLException ex) {
            
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            
        } finally {
            
            ConnectionFactory.closeConnection(con,stmt);
            
        }
    }
    
    public boolean checkLogin(String login, String pass) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        boolean check = false;

        try {

            stmt = con.prepareStatement("SELECT * FROM users_tb WHERE user_username = ? and user_password = ?");
            stmt.setString(1, login);
            stmt.setString(2, pass);

            rs = stmt.executeQuery();

            if (rs.next()) {
                User u = new User();
                u.setId(rs.getInt("user_id"));
                
                check = true;
            }

        } catch (SQLException ex) {
            
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            
        } finally {
            
            ConnectionFactory.closeConnection(con, stmt, rs);
            
        }

        return check;
    }
}
