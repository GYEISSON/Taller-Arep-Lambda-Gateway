package edu.escuelaing.arep;

import static spark.Spark.*;

import edu.escuelaing.arep.model.Calculator;
import org.json.simple.JSONObject;

import spark.Request;
import spark.Response;
/**
 * @autor Yeisson Gualdron
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        System.out.println( "Hello Temperature!" );
        port(getPort());
        get("/Temperature", (req, res) -> inputDataPage(req, res));

    }
    private static JSONObject inputDataPage(Request req, Response res)  {
        double number = Double.parseDouble(req.queryParams("value"));
        JSONObject out=new JSONObject();
        out.put("Celsius ", Calculator.fahrenheit_To_Celsius(number));
        out.put("Fahrenheit ", number);
        out.put("operation ","Fahrenheit To Celsius");

        return out;
    }


    public static  int getPort(){
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }

        return 4567;
    }
}
