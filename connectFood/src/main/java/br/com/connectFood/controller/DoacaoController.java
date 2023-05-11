package br.com.connectFood.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import br.com.connectFood.repository.DoacaoRepository;
import br.com.connectFood.services.DoacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.connectFood.model.DoacaoModel;

@RestController
@RequestMapping("/doacao")
@CrossOrigin("*")
public class DoacaoController {

    @Autowired
    private DoacaoService doacaoService;

    @PostMapping
    public ResponseEntity<Object> cadastrarDoacao(@RequestBody DoacaoModel doacao)
    {
        getDoacaoService().registerDonation(doacao);

        return ResponseEntity.ok().body("Doação registrada com sucesso!\n " + doacao);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteDoacao(@PathVariable(value = "id") int id)
    {
        getDoacaoService().deleteDonation(id);

        return ResponseEntity.ok().body("Doação " + id + " deletada!");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizarDoacao(@PathVariable(value = "id") int id, @RequestBody DoacaoModel doacao)
    {
        getDoacaoService().editDonation(id, doacao);

        return ResponseEntity.ok().body("Doação " + id + " atualizada com sucesso!");
    }

    @GetMapping
    public ResponseEntity<List<DoacaoModel>> getAllDoacao()
    {
        List<DoacaoModel> donations = getDoacaoService().getAllDonations();

        return ResponseEntity.ok(donations);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getDoacaoById(@PathVariable(value = "id") int id)
    {
        Optional<DoacaoModel> doacaoModel = getDoacaoService().getDonationById(id);

        return ResponseEntity.ok(doacaoModel);
    }

    @GetMapping("/restaurante/{nome}")
    public ResponseEntity<List<DoacaoModel>> getDoacaoByRestaurante(@PathVariable(value = "restaurante") String restaurante)
    {
        List<DoacaoModel> donations = getDoacaoService().getDonationByRestaurante(restaurante);

        return ResponseEntity.ok(donations);
    }

    @GetMapping("/instituicao/{nome}")
    public ResponseEntity<List<DoacaoModel>> getDoacaoByInstituicao(@PathVariable(value = "instituicao") String instituicao)
    {
        List<DoacaoModel> donaitons = getDoacaoService().getDonationByInstituicao(instituicao);

        return ResponseEntity.ok(donaitons);
    }

    @GetMapping("/date")
    public ResponseEntity<List<DoacaoModel>> getDoacaoByDate(@RequestParam (value = "date") String searchDate) throws ParseException {

        Date date = new SimpleDateFormat("dd/MM/yyyy").parse(searchDate);

        return ResponseEntity.ok(getDoacaoService().getDonationByDate(date));
    }

    @GetMapping("/date-between")
    public ResponseEntity<List<DoacaoModel>> getDoacaoBetweenDates(@RequestParam (value = "startDate") String startDate,
                                                                   @RequestParam (value = "endDate") String endDate) throws ParseException {

        Date startDateConverted = new SimpleDateFormat("dd/MM/yyyy").parse(startDate);
        Date endDateConverted = new SimpleDateFormat("dd/MM/yyyy").parse(endDate);

        return ResponseEntity.ok(getDoacaoService().getDonationByDateBetween(startDateConverted, endDateConverted));
    }

    @GetMapping("/date-before")
    public ResponseEntity<List<DoacaoModel>> getDoacaoByDateBefore(@RequestParam (value = "date") String searchDate) throws ParseException {

        Date date = new SimpleDateFormat("dd/MM/yyyy").parse(searchDate);

        return ResponseEntity.ok(getDoacaoService().findAllDonationBeforeDate(date));
    }

    public DoacaoService getDoacaoService() {
        return doacaoService;
    }

}