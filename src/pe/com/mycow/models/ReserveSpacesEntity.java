package pe.com.mycow.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReserveSpacesEntity extends BaseEntity{
    private static String DEFAULT_SQL = "SELECT * FROM MyCow.reserve_spaces";
    private List<ReserveSpace> findByCriteria(String sql) {
        List<ReserveSpace> reserveSpaces;
        if(getConnection() != null) {
            reserveSpaces = new ArrayList<>();
            try {
                ResultSet resultSet = getConnection()
                        .createStatement()
                        .executeQuery(sql);
                while (resultSet.next()) {
                    ReserveSpace reserveSpace = new ReserveSpace()
                            .setId(resultSet.getInt("id"))
                            .setReservationDate(resultSet.getString("reservation_date"))
                            .setNumHours(resultSet.getInt("num_hours"))
                            .setNumDays(resultSet.getInt("num_days"));
                    reserveSpaces.add(reserveSpace);
                }
                return reserveSpaces;

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public List<ReserveSpace> findAll() {
        return findByCriteria(DEFAULT_SQL);
    }

    public ReserveSpace findById(int id) {
        List<ReserveSpace> reserveSpaces = findByCriteria(DEFAULT_SQL +
                " WHERE id = "+ String.valueOf(id));
        return (reserveSpaces != null ? reserveSpaces.get(0) : null);
    }

    public ReserveSpace findByReservationDate(String reservationSpace) {
        List<ReserveSpace> reserveSpaces = findByCriteria(DEFAULT_SQL +
                " WHERE reservation_date = '" + reservationSpace + "'");
        return (reserveSpaces != null ? reserveSpaces.get(0) : null);
    }

    public ReserveSpace findByNumHours(int numHours) {
        List<ReserveSpace> reserveSpaces = findByCriteria(DEFAULT_SQL +
                " WHERE num_hours= " + String.valueOf(numHours));
        return (reserveSpaces != null ? reserveSpaces.get(0) : null);
    }

    public ReserveSpace findByNumDays(int numDays) {
        List<ReserveSpace> reserveSpaces = findByCriteria(DEFAULT_SQL +
                " WHERE num_days = " + String.valueOf(numDays));
        return (reserveSpaces != null ? reserveSpaces.get(0) : null);
    }



    private int updateByCriteria(String sql) {
        if(getConnection() != null) {
            try {
                return getConnection()
                        .createStatement()
                        .executeUpdate(sql);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    public boolean delete(int id) {
        return updateByCriteria("DELETE FROM reserve_spaces WHERE id = " + String.valueOf(id)) > 0;
    }

    private int getMaxId() {
        String sql = "SELECT MAX(id) AS max_id FROM reserve_spaces";
        if(getConnection() != null) {
            try {
                ResultSet resultSet = getConnection()
                        .createStatement()
                        .executeQuery(sql);
                return resultSet.next() ?
                        resultSet.getInt("max_id") : 0;
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return 0;
    }


    public ReserveSpace create(String reservationDate) {
        if(findByReservationDate(reservationDate) == null) {
            if(getConnection() != null) {
                String sql = "INSERT INTO reserve_spaces(id, reservation_date) VALUES(" +
                        String.valueOf(getMaxId() + 1) + ", '" +
                        reservationDate + "')";
                int results = updateByCriteria(sql);
                if(results > 0) {
                    ReserveSpace reserveSpace = new ReserveSpace(getMaxId(), reservationDate);

                    return reserveSpace;
                }
            }
        }
        return null;
    }

    public boolean update(ReserveSpace reserveSpace) {
        if(findByReservationDate(reserveSpace.getReservationDate()) != null) return false;
        return updateByCriteria(
                "UPDATE reserve_spaces SET reservation_date = '" +
                        reserveSpace.getReservationDate() + "'" +
                        " WHERE id = " +
                        String.valueOf(reserveSpace.getId())) > 0;
    }
}
