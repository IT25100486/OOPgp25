package Controller;

import Entity.RateChart;
import Repository.RateChartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratechart")
public class RateChartController {

    @Autowired
    private RateChartRepository rateRepo;

    @PostMapping
    public RateChart addRate(@RequestBody RateChart rateChart) {
        return rateRepo.save(rateChart);
    }

    @GetMapping
    public List<RateChart> getRates() {
        return rateRepo.findAll();
    }
}