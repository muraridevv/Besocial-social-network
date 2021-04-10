package murari.besocial.web.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import murari.besocial.domain.models.serviceModels.LoggerServiceModel;
import murari.besocial.domain.models.viewModels.LoggerViewModel;
import murari.besocial.services.LoggerService;
import murari.besocial.utils.responseHandler.CustomException;
import murari.besocial.utils.responseHandler.SuccessResponse;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static murari.besocial.utils.constants.ResponseMessageConstants.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/logs")
public class LoggerController {
    private final LoggerService loggerService;
    private final ModelMapper modelMapper;
    private final ObjectMapper objectMapper;

    @Autowired
    public LoggerController(LoggerService loggerService, ModelMapper modelMapper, ObjectMapper objectMapper) {
        this.loggerService = loggerService;
        this.modelMapper = modelMapper;
        this.objectMapper = objectMapper;
    }

    @GetMapping(value = "/all")
    public List<LoggerViewModel> allLogs() {
        List<LoggerServiceModel> allLogs = this.loggerService.getAllLogs();

        return allLogs.stream()
                .map(this::parseDate)
                .collect(Collectors.toList());
    }

    @GetMapping(value = "/findByUserName/{username}")
    public List<LoggerViewModel> getLogsByUsername(@PathVariable String username) {
        return this.loggerService
                .getLogsByUsername(username)
                .stream()
                .map(this::parseDate)
                .collect(Collectors.toList());
    }

    @DeleteMapping(value = "/clear")
    public ResponseEntity deleteLogs() throws JsonProcessingException {
        boolean result = this.loggerService.deleteAll();

        if (result) {
            SuccessResponse successResponse = new SuccessResponse(LocalDateTime.now(), SUCCESSFUL_LOGS_DELETING_MESSAGE, "", true);
            return new ResponseEntity<>(this.objectMapper.writeValueAsString(successResponse), HttpStatus.OK);
        }
        throw new CustomException(SERVER_ERROR_MESSAGE);
    }

    @DeleteMapping(value = "/clearByName/{username}")
    public ResponseEntity deleteLogsByName(@PathVariable String username) throws JsonProcessingException {
        boolean result = this.loggerService.deleteByName(username);

        if (result) {
            SuccessResponse successResponse = new SuccessResponse(LocalDateTime.now(), SUCCESSFUL_USER_LOGS_DELETING_MESSAGE, "", true);
            return new ResponseEntity<>(this.objectMapper.writeValueAsString(successResponse), HttpStatus.OK);
        }
        throw new CustomException(SERVER_ERROR_MESSAGE);
    }

    private LoggerViewModel parseDate(LoggerServiceModel x) {
        LoggerViewModel loggerViewModel = new LoggerViewModel();
        this.modelMapper.map(x, loggerViewModel);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy HH:mm:ss");
        String formattedDateTime = x.getTime().format(formatter);
        loggerViewModel.setTime(formattedDateTime);
        return loggerViewModel;
    }
}
