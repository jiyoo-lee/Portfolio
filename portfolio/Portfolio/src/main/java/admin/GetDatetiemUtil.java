package admin;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class GetDatetiemUtil {
		// 시간 날짜 
		public String getNowDatetime() {
			
			LocalDateTime datetime = LocalDateTime.now();
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			String todayDateTime = datetime.format(dtf);
			
			return todayDateTime;
		}
		
		// 날짜
		public String getNowDate() {
			
			LocalDate date = LocalDate.now();
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			String todayDate = date.format(dtf);
			
			return todayDate;
		}
		
		// 시간만
		public String getNowTime() {
			
			LocalTime time = LocalTime.now();
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			String todayTime = time.format(dtf);
			
			return todayTime;
		}
}
