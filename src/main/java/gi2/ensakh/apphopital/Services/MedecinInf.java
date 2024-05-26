package gi2.ensakh.apphopital.Services;

import gi2.ensakh.apphopital.Dtos.inscriptionDto;
import gi2.ensakh.apphopital.Entities.Medecin;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface MedecinInf {
    Medecin getMedByName(String nom);

    List<Medecin> getAllMedecin();

    Medecin getMedecinByCin(String id);




    void InsertMedecinCompteV(inscriptionDto inscription);
}
