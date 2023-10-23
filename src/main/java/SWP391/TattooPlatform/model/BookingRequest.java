package SWP391.TattooPlatform.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingRequest {
    private Booking booking;
    private List<BookingDetail> bookingDetails;

    private String date;
    private String start_time;
    private String end_time;
}
