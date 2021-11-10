package dbconection;

public class Queries {
	public static String returnQuery(String queryOption) {
		String query = "";
		switch(queryOption){
			case "select": return "select * from test";
			case "selectFrom2Tables": return "select t2.id, t2.batchId, t2.locationNumber from test2 t2\r\n"
					+ "join test3 t3\r\n"
					+ "on t2.batchId = t3.batchId";
		}
		return query;
	}
}
