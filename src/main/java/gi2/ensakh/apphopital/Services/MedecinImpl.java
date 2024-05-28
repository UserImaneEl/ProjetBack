package gi2.ensakh.apphopital.Services;

import gi2.ensakh.apphopital.Dtos.inscriptionDto;
import gi2.ensakh.apphopital.Entities.Compte;
import gi2.ensakh.apphopital.Entities.Medecin;
import gi2.ensakh.apphopital.Mappers.HopitalMappers;
import gi2.ensakh.apphopital.Repositories.CompteRepository;
import gi2.ensakh.apphopital.Repositories.MedecinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.List;
@Component
public class MedecinImpl implements MedecinInf{

    @Autowired
    MedecinRepository md ;
    @Autowired
    public CompteRepository CR;
    @Autowired
    public HopitalMappers hopitalMappers;

    @Override
    public Medecin getMedByName(String nom) {
        return md.getMedByName(nom);
}

        @Override
        public List<Medecin> getAllMedecin() {
            return md.findAll();
        }

        @Override
        public Medecin getMedecinByCin(String id) {
            return md.findByCin(id);
        }

    @Override
    public void InsertMedecinCompteV(inscriptionDto inscription) {
            Compte compte=hopitalMappers.convertInscriptionToCompteMed(inscription);
            CR.save(compte);
            Medecin med=hopitalMappers.convertInscriptionToMed(inscription);

            md.save(med);
}


    }

