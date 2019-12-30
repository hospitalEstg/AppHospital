package pt.ipleiria.estg.dei.hospitalestg.modelo;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ConsultaBDHelper extends SQLiteOpenHelper {

    private static final String DB_NAME="HospitalBD";
    private static final int DB_VERSION=1;

    private static final String TABLE_NAME="Consultas";

    private static final String ID_CONSULTA="id";
    private static final String MEDICO_CONSULTA="medico";
    private static final String MOTIVO_CONSULTA="motivo";
    private static final String DATA_CONSULTA="data";
    private static final String HORA_CONSULTA="hora";

    private final SQLiteDatabase database;

    public ConsultaBDHelper(@Nullable Context context){
        super(context, DB_NAME, null, DB_VERSION);
        this.database=getWritableDatabase();

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableConsulta = "CREATE TABLE "+TABLE_NAME+
                "( "+ID_CONSULTA+ " INTEGER PRIMARY KEY AUTOINCREMENT, "+
                MEDICO_CONSULTA + " TEXT NOT NULL, "+
                MOTIVO_CONSULTA+ " TEXT NOT NULL, "+
                DATA_CONSULTA+ " TEXT NOT NULL, "+
                HORA_CONSULTA+ " TEXT NOT NULL);";

        db.execSQL(createTableConsulta);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS "+ TABLE_NAME);
        this.onCreate(db);

    }

    /********************** Operações CRUD ***************************/
    public ArrayList<Consulta> getAllConsultasDB() {
        ArrayList<Consulta>consultas = new ArrayList<>();
        //Cursor e para ir buscar os dados a base de dados
        //database.query(tableName, tablesColunas, whereClause,whereArgs, groupBy, havingClause, orderBy)
        //database.rawQuery(sql,args
        Cursor cursor = this.database.query(TABLE_NAME, new String[]{ID_CONSULTA,MEDICO_CONSULTA,MOTIVO_CONSULTA,DATA_CONSULTA,HORA_CONSULTA},null,null,null, null, null );

        if(cursor.moveToFirst()){
            do{
                Consulta auxConsulta = new Consulta(cursor.getInt(0),cursor.getString(1), cursor.getString(2),cursor.getString(3),cursor.getString(4)/*, cursor.getString(5)*/);
                consultas.add(auxConsulta);
            }while(cursor.moveToNext());
            cursor.close();
        }
        //database.rawQuery("SELECT * FROM "+ TABLE_NAME+ /*" WHERE "+ TITULO_LIVRO + " LIKE '0?0'"*/null, null /* new String[] {"blabala"}*/);
        return consultas;
    }
}
