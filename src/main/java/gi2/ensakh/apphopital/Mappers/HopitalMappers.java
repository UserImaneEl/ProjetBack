package gi2.ensakh.apphopital.Mappers;

import gi2.ensakh.apphopital.Dtos.*;
import gi2.ensakh.apphopital.Entities.*;
import gi2.ensakh.apphopital.Repositories.CompteRepository;
import gi2.ensakh.apphopital.Repositories.DepartementRepository;
import gi2.ensakh.apphopital.Repositories.MedecinRepository;
import gi2.ensakh.apphopital.Repositories.PatientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import org.springframework.security.crypto.password.PasswordEncoder;

@AllArgsConstructor
@Service
public class HopitalMappers {
    PatientRepository patientRepository;
    MedecinRepository medecinRepository;
    CompteRepository compteRepository;
    DepartementRepository dr;
    PasswordEncoder passwordEncoder;

    public PatientRdvDto fromPatientRdv(RendezVous Rendezvous) {
        PatientRdvDto patientRdvDto = new PatientRdvDto();
        patientRdvDto.setIdRdv(Rendezvous.getId());
        patientRdvDto.setCin(Rendezvous.getPatient().getCin());
        patientRdvDto.setNom(Rendezvous.getPatient().getNom());
        patientRdvDto.setPrenom(Rendezvous.getPatient().getPrenom());
        patientRdvDto.setTel(Rendezvous.getPatient().getTel());
        patientRdvDto.setEmail(Rendezvous.getPatient().getEmail());
        patientRdvDto.setStatusRDV(Rendezvous.getStatusRDV());
        patientRdvDto.setDate(Rendezvous.getDate_demande());
        patientRdvDto.setCin_med(Rendezvous.getMedecin().getCin());
        patientRdvDto.setNom_med(Rendezvous.getMedecin().getNom());
        patientRdvDto.setPrenom_med(Rendezvous.getMedecin().getPrenom());
        patientRdvDto.setCin_sec(Rendezvous.getMedecin().getDep().getSecretaire().getCin());
        return patientRdvDto;
    }

    public RendezVous fromRdvDTO(RdvDto rdvDto) {
        RendezVous rendezVous = new RendezVous();
        Compte compte = compteRepository.findCompteByUsername(rdvDto.getUsername());
        Patient patient = new Patient();
        rendezVous.setStatusRDV(rdvDto.getStatusRDV());
        patient.setNom(rdvDto.getNom());
        patient.setPrenom(rdvDto.getPrenom());
        patient.setTel(rdvDto.getTel());
        patient.setEmail(rdvDto.getEmail());
        patient.setCin(rdvDto.getPatientCin());
        patientRepository.save(patient);
        rendezVous.setPatient(patient);
        rendezVous.setStatusRDV(rdvDto.getStatusRDV());
        rendezVous.setMedecin(medecinRepository.findByCin(rdvDto.getDRcin()));
        //rendezVous.setDate_demande(rdvDto.getDate_demande());
        rendezVous.setCompte(compte);

        return rendezVous;
    }

    public medecinDto fromMedToDto(Medecin med) {
        medecinDto m = new medecinDto();
        m.setCin(med.getCin());
        m.setNom(med.getNom());
        m.setPrenom(med.getPrenom());
        m.setSpecialite(med.getSpecialite());
        m.setDuree(med.getDurationRDV());
        m.setLimit(med.getLimitNumRDV());
        m.setEmail(med.getEmail());
        m.setAdr(med.getAdresse());
        m.setTel(med.getTel());
        return m;
    }

    public PersonneDto fromPerToDto(Personne p) {
        PersonneDto m = new PersonneDto();
        m.setCin(p.getCin());
        m.setNom(p.getNom());
        m.setPrenom(p.getPrenom());
        m.setEmail(p.getEmail());
        m.setAdr(p.getAdresse());
        m.setTel(p.getTel());

        return m;
    }

    public Medecin convertInscriptionToMed(inscriptionDto inscription) {
        Medecin med = new Medecin();
        med.setCin(inscription.getCin());
        Compte c = new Compte();
        c = compteRepository.findCompteByUsername(inscription.getUsername());
        med.setCompte(c);
        //  System.out.println("mdp"+med.getCompte().getUsername());
        med.setNom(inscription.getNom());
        med.setPrenom(inscription.getPrenom());
        med.setTel(inscription.getTel());
        med.setEmail(inscription.getEmail());
        med.setDateN(inscription.getDateN());
        med.setAdresse(inscription.getAdresse());
        med.setSpecialite(inscription.getSpecialite());
        med.setDep(dr.findByNom_dep(inscription.getDep()));
        // System.out.println("dep"+med.getDep().getNom_dep());

        return med;


    }


    public Compte convertInscriptionToCompteMed(inscriptionDto inscription) {
        Compte c = new Compte();
        c.setUsername(inscription.getUsername());
        c.setMdp(passwordEncoder.encode(inscription.getMdp()));
        System.out.println(c.getMdp());
        c.setRole(Role.MEDECIN);
        return c;


    }

}
