package rs.edu.raf.opcija.servis;

import rs.edu.raf.opcija.dto.NovaOpcijaDto;
import rs.edu.raf.opcija.dto.OpcijaDto;
import rs.edu.raf.opcija.model.KorisnikoveKupljeneOpcije;
import rs.edu.raf.opcija.model.OpcijaStanje;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Map;

public interface OpcijaServis {

        List<OpcijaDto> findAll() throws InterruptedException;

        OpcijaDto save(NovaOpcijaDto option);

        OpcijaDto findById(Long id);

        void azuirajPostojeceOpcije() throws IOException;

        List<OpcijaDto> findByStockAndDateAndStrike(String ticker, LocalDateTime datumIstekaVazenja, Double strikePrice);

        KorisnikoveKupljeneOpcije izvrsiOpciju(Long opcijaId, Long userId);

        OpcijaStanje proveriStanjeOpcije(Long opcijaId);

        Map<String, List<OpcijaDto>> findPutsAndCallsByStockTicker(String ticker);

        Map<String, List<OpcijaDto>> findPutsAndCallsByStockTickerAndExpirationDate(String ticker, Date startOfDay, Date endOfDay);

        Map<String, List<OpcijaDto>> classifyOptions(String ticker);

}
