package br.com.connectFood.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import br.com.connectFood.repository.DoacaoRepository;
import br.com.connectFood.services.DoacaoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.connectFood.model.DoacaoModel;

@RestController
@RequestMapping("/doacao")
@CrossOrigin(value = "*", allowedHeaders = "*")
@Api(tags = "API de Doações")
public class DoacaoController {

    @Autowired
    private DoacaoService doacaoService;

    @PostMapping
    @ApiOperation("Cadastrar uma doação")
    public ResponseEntity<Object> cadastrarDoacao(@RequestBody DoacaoModel doacao)
    {
        getDoacaoService().registerDonation(doacao);

        return ResponseEntity.ok().body("Doação registrada com sucesso!\n " + doacao);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Deletar uma doação")
    public ResponseEntity<Object> deleteDoacao(@PathVariable(value = "id") int id)
    {
        getDoacaoService().deleteDonation(id);

        return ResponseEntity.ok().body("Doação " + id + " deletada!");
    }

    @PutMapping("/{id}")
    @ApiOperation("Atualizar uma doação")
    public ResponseEntity<Object> atualizarDoacao(@PathVariable(value = "id") int id, @RequestBody DoacaoModel doacao)
    {
        getDoacaoService().editDonation(id, doacao);

        return ResponseEntity.ok().body("Doação " + id + " atualizada com sucesso!");
    }

    @GetMapping
    @ApiOperation("Trazer todas as doações")
    public ResponseEntity<List<DoacaoModel>> getAllDoacao()
    {
        List<DoacaoModel> donations = getDoacaoService().getAllDonations();

        return ResponseEntity.ok(donations);
    }

    @GetMapping("/{id}")
    @ApiOperation("Trazer uma doação pelo ID")
    public ResponseEntity<Object> getDoacaoById(@PathVariable(value = "id") int id)
    {
        Optional<DoacaoModel> doacaoModel = getDoacaoService().getDonationById(id);

        return ResponseEntity.ok(doacaoModel);
    }

    @GetMapping("/restaurante/{nome}")
    @ApiOperation("Trazer doações de um restaurante")
    public ResponseEntity<List<DoacaoModel>> getDoacaoByRestaurante(@PathVariable(value = "restaurante") String restaurante)
    {
        List<DoacaoModel> donations = getDoacaoService().getDonationByRestaurante(restaurante);

        return ResponseEntity.ok(donations);
    }

    @GetMapping("/instituicao/{nome}")
    @ApiOperation("Trazer doações de uma Instituição")
    public ResponseEntity<List<DoacaoModel>> getDoacaoByInstituicao(@PathVariable(value = "instituicao") String instituicao)
    {
        List<DoacaoModel> donaitons = getDoacaoService().getDonationByInstituicao(instituicao);

        return ResponseEntity.ok(donaitons);
    }

    @GetMapping("/date")
    @ApiOperation("Trazer doações por uma data")
    public ResponseEntity<List<DoacaoModel>> getDoacaoByDate(@RequestParam (value = "date") String searchDate) throws ParseException {

        Date date = new SimpleDateFormat("dd/MM/yyyy").parse(searchDate);

        return ResponseEntity.ok(getDoacaoService().getDonationByDate(date));
    }

    @GetMapping("/date-between")
    @ApiOperation("Trazer doações por um período de tempo")
    public ResponseEntity<List<DoacaoModel>> getDoacaoBetweenDates(@RequestParam (value = "startDate") String startDate,
                                                                   @RequestParam (value = "endDate") String endDate) throws ParseException {

        Date startDateConverted = new SimpleDateFormat("dd/MM/yyyy").parse(startDate);
        Date endDateConverted = new SimpleDateFormat("dd/MM/yyyy").parse(endDate);

        return ResponseEntity.ok(getDoacaoService().getDonationByDateBetween(startDateConverted, endDateConverted));
    }

    public DoacaoService getDoacaoService() {
        return doacaoService;
    }

}