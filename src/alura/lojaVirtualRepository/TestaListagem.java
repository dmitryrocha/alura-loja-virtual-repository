package alura.lojaVirtualRepository;

import java.sql.*;

public class TestaListagem {
    public static void main(String[] args) throws SQLException {

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/loja_virtual?useTimezone=true&serverTimezone=UTC","root","root");

            Statement stm =  connection.createStatement();
            stm.execute("SELECT ID, NOME, DESCRICAO FROM PRODUTO");
            ResultSet resultSet = stm.getResultSet();

            while(resultSet.next()) {
                Integer id = resultSet.getInt("ID");
                String nome = resultSet.getString("NOME");
                String descricao = resultSet.getString("DESCRICAO");
                System.out.println(id + " - " + nome + " - " + descricao);
            }


            connection.close();

    }
}
