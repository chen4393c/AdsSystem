package rpc;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import db.DBConnection;
import db.DBConnectionFactory;

/**
 * Servlet implementation class CreateAd
 */
@WebServlet("/CreateAd")
public class CreateAd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateAd() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DBConnection conn = DBConnectionFactory.getConnection();
		
		//INSERT INTO `ad`(`bid`, `image_url`, `advertiser_id`, `ad_score`) VALUES ([value-1],[value-2],[value-3],[value-4])
		try {
			JSONObject input = RpcHelper.readJSONObject(request);
			double bid = input.getDouble("bid");
			String imageUrl = input.getString("image_url");
			int advertiserId = input.getInt("advertiser_id");
			double adScore = input.getDouble("ad_score");
			
			long adId = conn.createAd(bid, imageUrl, advertiserId, adScore);
			RpcHelper.writeJSONObject(response, 
					new JSONObject().put("ad_id", adId));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
	}

}
