package SWP391.TattooPlatform.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ResponseStudioService {
    private Studio studio;
    private List<Service> service;
}
