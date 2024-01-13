package com.TransfertNational.demo;

import com.TransfertNational.demo.Entities.*;
import com.TransfertNational.demo.Repositorys.*;
import com.TransfertNational.demo.Services.SalesforceAPIServ;
import com.TransfertNational.demo.Shared.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@SpringBootApplication

public class TransfertNationalApplication implements CommandLineRunner {
	@Autowired
	ClientRepository clientRepository;
	@Autowired
	AgenceRepository agenceRepository;
	@Autowired
	CompteRepository compteRepository;
	@Autowired
	AgentRepository agentRepository;
	@Autowired
	AdminRepository adminRepository;
	@Autowired
	TransfertRepository transfertRepository;
	@Autowired
	Utils utils;

	@Autowired
	SalesforceAPIServ salesforceAPIServ;

	public static void main(String[] args) {
		SpringApplication.run(TransfertNationalApplication.class, args);
	}



	@SuppressWarnings("deprecation")
	@Override
	public void run(String... args) throws Exception {





		//ADMIN______________________________________________________________
		Admin admin1 = new Admin();
		admin1.setFullName("Youssefberramdane");
		admin1.setAdminName("admin1");
		admin1.setPassword("passwordAdmin1");
		adminRepository.save(admin1);

		Admin admin2 = new Admin();
		admin2.setFullName("OmarBanini");
		admin2.setAdminName("admin2");
		admin2.setPassword("passwordAdmin2");
		adminRepository.save(admin2);

		// CLIENTS___________________________________________________________
		Client salesforceClient = new Client();
		salesforceClient.setClientId(utils.generateStringId(30));
		salesforceClient.setTitre("M");
		salesforceClient.setFullName("Nissrin chakiri");
		salesforceClient.setGSM("0606060606");
		salesforceClient.setEmail("chakirinisrine@gmail.com");
		salesforceClient.setClientId("nissrinId");
		salesforceClient.setHasCompte(true);
		clientRepository.save(salesforceClient);


		Client clientEntity1 = new Client();
		clientEntity1.setClientId(utils.generateStringId(30));
		clientEntity1.setTitre("M");
		clientEntity1.setFullName("Safaa chafii");
		clientEntity1.setGSM("0606060606");
		clientEntity1.setEmail("chafii@gmail.com");
		clientEntity1.setHasCompte(true);
		clientRepository.save(clientEntity1);


		Client clientEntity2 = new Client();
		clientEntity2.setClientId(utils.generateStringId(30));
		clientEntity2.setTitre("M");
		clientEntity2.setFullName("Ahlam Channa");
		clientEntity2.setGSM("0707070707");
		clientEntity2.setEmail("ahlamchanna123@gmail.com");
		clientEntity2.setHasCompte(true);
		clientRepository.save(clientEntity2);

		Client clientEntity3 = new Client();
		clientEntity3.setClientId(utils.generateStringId(30));
		clientEntity3.setTitre("M");
		clientEntity3.setFullName("Labnine mohammed");
		clientEntity3.setGSM("0919191919");
		clientEntity3.setEmail("mohamedlabnine1@gmail.com");
		clientEntity3.setHasCompte(true);
		clientRepository.save(clientEntity3);

		Client clientEntity4 = new Client();
		clientEntity4.setClientId(utils.generateStringId(30));
		clientEntity4.setTitre("M");
		clientEntity4.setFullName("Reda Hjaami");
		clientEntity4.setGSM("0610203540");
		clientEntity4.setEmail("reda@gmail.com");
		clientEntity4.setHasCompte(true);
		clientRepository.save(clientEntity4);



		//COMPTE___________________________________________________________

		Compte comptesalesforce = new Compte();
		comptesalesforce.setCompteId(utils.generateStringId(30));
		comptesalesforce.setNumCompte(utils.generateNumbre(16));
		comptesalesforce.setSolde(1000000);
		comptesalesforce.setClient(salesforceClient);
		compteRepository.save(comptesalesforce);


		Compte compteEntity1 = new Compte();
		compteEntity1.setCompteId(utils.generateStringId(30));
		compteEntity1.setNumCompte(utils.generateNumbre(16));
		compteEntity1.setSolde(10000);
		compteEntity1.setClient(clientEntity1);
		compteRepository.save(compteEntity1);

		Compte compteEntity2 = new Compte();
		compteEntity2.setCompteId(utils.generateStringId(30));
		compteEntity2.setNumCompte(utils.generateNumbre(16));
		compteEntity2.setSolde(20000);
		compteEntity2.setClient(clientEntity2);
		compteRepository.save(compteEntity2);

		Compte compteEntity3 = new Compte();
		compteEntity3.setCompteId(utils.generateStringId(30));
		compteEntity3.setNumCompte(utils.generateNumbre(16));
		compteEntity3.setSolde(30000);
		compteEntity3.setClient(clientEntity3);
		compteRepository.save(compteEntity3);

		Compte compteEntity4 = new Compte();
		compteEntity4.setCompteId(utils.generateStringId(30));
		compteEntity4.setNumCompte(utils.generateNumbre(16));
		compteEntity4.setSolde(40000);
		compteEntity4.setClient(clientEntity4);
		compteRepository.save(compteEntity4);





		//AGENCE____________________________________________________________

		Agence agenceEntity1 = new Agence();
		agenceEntity1.setAdresseAgence("angle Avenue du Parc et, Rue Ibn Rochd, Mohammedia");
		agenceEntity1.setActive(true);
		agenceEntity1.setVilleAgence("Mohammedia");
		agenceEntity1.setNomAgence("Agence Mohammedia");
		agenceEntity1.setTelephoneAgence("0661968774");
		agenceRepository.save(agenceEntity1);

		Agence agenceEntity2 = new Agence();
		agenceEntity2.setAdresseAgence("rue Ahmed Sebbagh, and rue 71 derb El Kabir, 20490");
		agenceEntity2.setActive(true);
		agenceEntity2.setVilleAgence("Casablanca");
		agenceEntity2.setNomAgence("Agence Ouled Ziane");
		agenceEntity2.setTelephoneAgence("0000000000");
		agenceRepository.save(agenceEntity2);

		//AGENT_____________________________________________________________

		Agent agentEntity1 = new Agent();
		agentEntity1.setUsername("agent1");
		agentEntity1.setEncryptedPassword("passwordAgent1");
		agentEntity1.setAgence(agenceEntity1);
		agentRepository.save(agentEntity1);

		Agent agentEntity2 = new Agent();
		agentEntity2.setUsername("agent2");
		agentEntity2.setEncryptedPassword("passwordAgent2");
		agentEntity2.setAgence(agenceEntity1);
		agentRepository.save(agentEntity2);

		Agent agentEntity3 = new Agent();
		agentEntity3.setUsername("agent3");
		agentEntity3.setEncryptedPassword("passwordAgent3");
		agentEntity3.setAgence(agenceEntity1);
		agentRepository.save(agentEntity3);

		Agent agentEntity4 = new Agent();
		agentEntity4.setUsername("agent4");
		agentEntity4.setEncryptedPassword("passwordAgent4");
		agentEntity4.setAgence(agenceEntity2);
		agentRepository.save(agentEntity4);

		Agent agentEntity5 = new Agent();
		agentEntity5.setUsername("agent5");
		agentEntity5.setEncryptedPassword("passwordAgent5");
		agentEntity5.setAgence(agenceEntity2);
		agentRepository.save(agentEntity5);

		//TRANSFERT_____________________________________________________________________

		Date now = new Date(System.currentTimeMillis());


		Transfert transfert1 = new Transfert();
		transfert1.setTransfertId(utils.generateStringId(30));
		transfert1.setReferenceTransfert("837" + utils.generateNumbre(10));
		transfert1.setPin(utils.generateNumbre(4));
		transfert1.setEtat("A servir");
		transfert1.setMontant((float)5500.00);
		transfert1.setMotif("Crédit");
		transfert1.setNotification(true);
		transfert1.setGAB_BOA(false);
		transfert1.setClientDonneur(clientEntity1);
		transfert1.setClientBeneficaire(clientEntity2);
		transfert1.setTypeTransfert("Walett");
		transfertRepository.save(transfert1);

		Transfert transfert2 = new Transfert();
		transfert2.setTransfertId(utils.generateStringId(30));
		transfert2.setReferenceTransfert("837" + utils.generateNumbre(10));
		transfert2.setPin(utils.generateNumbre(4));
		transfert2.setEtat("Déshérence");
		transfert2.setMontant((float)1000);
		transfert2.setMotif("Pour un motif familial");
		transfert2.setNotification(true);
		transfert2.setGAB_BOA(true);
		transfert2.setClientDonneur(clientEntity1);
		transfert2.setClientBeneficaire(clientEntity2);
		transfert2.setTypeTransfert("GAB BOA");
		transfert2.setDelaiTransfert(0);
		transfertRepository.save(transfert2);

		now.setDate(now.getDay()+3);
		Transfert transfert3 = new Transfert();
		transfert3.setDateReception(now);
		transfert3.setTransfertId(utils.generateStringId(30));
		transfert3.setReferenceTransfert("837" + utils.generateNumbre(10));
		transfert3.setPin(utils.generateNumbre(4));
		transfert3.setEtat("Servie");
		transfert3.setMontant((float)149.99);
		transfert3.setMotif("Achat");
		transfert3.setNotification(true);
		transfert3.setGAB_BOA(false);
		transfert3.setClientDonneur(clientEntity1);
		transfert3.setClientBeneficaire(clientEntity2);
		transfert3.setTypeTransfert("Walett");
		transfertRepository.save(transfert3);

		Transfert transfert4 = new Transfert();
		transfert4.setTransfertId(utils.generateStringId(30));
		transfert4.setReferenceTransfert("837" + utils.generateNumbre(10));
		transfert4.setPin(utils.generateNumbre(4));
		transfert4.setEtat("A servir");
		transfert4.setMontant((float)200);
		transfert4.setMotif("My Friend");
		transfert4.setNotification(true);
		transfert4.setGAB_BOA(false);
		transfert4.setClientDonneur(clientEntity1);
		transfert4.setClientBeneficaire(clientEntity2);
		transfert4.setTypeTransfert("Walett");
		transfertRepository.save(transfert4);

		Transfert transfert5 = new Transfert();
		transfert5.setTransfertId(utils.generateStringId(30));
		transfert5.setReferenceTransfert("837" + utils.generateNumbre(10));
		transfert5.setPin(utils.generateNumbre(4));
		transfert5.setEtat("A servir");
		transfert5.setMontant((float)4500);
		transfert5.setMotif("Louer appartement");
		transfert5.setNotification(true);
		transfert5.setGAB_BOA(false);
		transfert5.setClientDonneur(clientEntity1);
		transfert5.setClientBeneficaire(clientEntity2);
		transfert5.setTypeTransfert("Walett");
		transfertRepository.save(transfert5);

		now.setDate(now.getDay()+3);
		Transfert transfert6 = new Transfert();
		transfert6.setDateReception(now);
		transfert6.setTransfertId(utils.generateStringId(30));
		transfert6.setReferenceTransfert("837" + utils.generateNumbre(10));
		transfert6.setPin(utils.generateNumbre(4));
		transfert6.setEtat("Servie");
		transfert6.setMontant((float)500);
		transfert6.setMotif("WIFI");
		transfert6.setNotification(true);
		transfert6.setGAB_BOA(false);
		transfert6.setClientDonneur(clientEntity1);
		transfert6.setClientBeneficaire(clientEntity2);
		transfert6.setTypeTransfert("Walett");
		transfertRepository.save(transfert6);

		Transfert transfert7 = new Transfert();
		transfert7.setTransfertId(utils.generateStringId(30));
		transfert7.setReferenceTransfert("837" + utils.generateNumbre(10));
		transfert7.setPin(utils.generateNumbre(4));
		transfert7.setEtat("Bloqué");
		transfert7.setMontant((float)650);
		transfert7.setMotif("Crédit");
		transfert7.setNotification(true);
		transfert7.setGAB_BOA(true);
		transfert7.setClientDonneur(clientEntity1);
		transfert7.setClientBeneficaire(clientEntity2);
		transfert7.setTypeTransfert("GAB BOA");
		transfertRepository.save(transfert7);
	}
	/*@Bean
	public CorsFilter corsFilter() {
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.setAllowCredentials(true);
		corsConfiguration.addAllowedOrigin("https://banking-50249.web.app");

		corsConfiguration.addAllowedHeader("*");
		corsConfiguration.addAllowedMethod("*");
		corsConfiguration.addExposedHeader("*");
		UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
		urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
		return new CorsFilter(urlBasedCorsConfigurationSource);
	}*/
	@Bean
	public CorsConfigurationSource corsConfigurationSource(){
		CorsConfiguration corsConfiguration=new CorsConfiguration();
		corsConfiguration.addAllowedOrigin("*");
		corsConfiguration.addAllowedMethod("*");
		corsConfiguration.addAllowedHeader("*");
		corsConfiguration.addExposedHeader("*");
		UrlBasedCorsConfigurationSource source=new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**",corsConfiguration);
		return source;

	}
}
