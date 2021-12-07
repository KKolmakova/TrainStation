//package com.kolmakova.controllers;
//
//import com.kolmakova.entities.Passenger;
//import com.kolmakova.entities.Train;
//import com.kolmakova.services.PassengerService;
//import com.kolmakova.services.TrainService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@Controller
//@RequestMapping("/train")
//public class PageController {
//
//    @Autowired
//    private TrainService trainService;
//    @Autowired
//    private PassengerService passengerService;
//
//    @GetMapping("/main")
//    public String selectTrains() {
//        return "train/select";
//    }
//
//    @PostMapping("/find")
//    public String findSelected(Model model, Train train) {
//        List<Train> trains = trainService.getByArrivalPlace(train.getArrivalPlace());
//        model.addAttribute("find", true);
//        model.addAttribute("trains", trains);
//        model.addAttribute("trainIds", trainService.getSelectedTrainsUrl(trains));
//
//        return "train/select";
//    }
//
//    @GetMapping("/main/{id}")
//    public String test1(){
//        return "train/select";
//    }
//
//    @GetMapping("/main/{id}/test/{otherId}")
//    public String test2(){
//        return "train/select";
//    }
//
//    @PostMapping("/match/{trainIds}/selected/{selectedTrainId}")
//    public String chooseTrain(Model model,
//                              @PathVariable("trainIds") List<Integer> trainIds,
//                              @PathVariable("selectedTrainId") Integer selectedTrainId) {
//        model.addAttribute("choose", true);
//        model.addAttribute("trains", trainService.getTrainsByIds(trainIds));
//        model.addAttribute("train", trainService.getTrainById(selectedTrainId));
//
//        return "train/select";
//    }
//
//    @PostMapping("/match/{trainIds}/selected/{selectedTrainId}/passenger/newPassenger")
//    public String enterNewPassenger(Model model, Passenger passenger,
//                                    @PathVariable("selectedTrainId") Integer selectedTrainId) {
//        model.addAttribute("newPassenger", true);
//        model.addAttribute("passenger", passenger);
//        model.addAttribute("train", trainService.getTrainById(selectedTrainId));
//
//        return "train/select";
//    }
//}
