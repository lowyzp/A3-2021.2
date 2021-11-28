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
                u.setName(rs.getString("user_name"));
                u.setUsername(rs.getString("user_username"));
                u.setPassword(rs.getString("user_password"));
                u.setEmail(rs.getString("user_email"));
                u.setPhone(rs.getString("user_phone"));

                
                check = true;
            }

        } catch (SQLException ex) {
            
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            
        } finally {
            
            ConnectionFactory.closeConnection(con, stmt, rs);
            
        }

        return check;
    }
    
    public void update(User u) {

        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE users_tb SET "
                    + "user_name = ?, "
                    + "user_username = ?, "
                    + "user_password = ?, "
                    + "user_email = ?, "
                    + "user_phone = ?"
                    + " WHERE user_id = ?");
            
            stmt.setString(1, u.getName());
            stmt.setString(2, u.getUsername());
            stmt.setString(3, u.getPassword());
            stmt.setString(4, u.getEmail());
            stmt.setString(5, u.getPhone());

            stmt.setInt(6, u.getId());

            stmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
    
        public void delete(int p) {

        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM users_tb WHERE user_id = ?");
            stmt.setInt(1, p);

            stmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
    
}
