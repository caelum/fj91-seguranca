package br.com.caelum.fj91.seguranca.services.auth.events;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationFailureEventListener implements ApplicationListener<AuthenticationFailureBadCredentialsEvent> {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public void onApplicationEvent(AuthenticationFailureBadCredentialsEvent event) {
		WebAuthenticationDetails auth = (WebAuthenticationDetails) event.getAuthentication().getDetails();
		gerarLog(auth, event);
	}

	private void gerarLog(WebAuthenticationDetails auth, AuthenticationFailureBadCredentialsEvent event) {
		String ip = auth.getRemoteAddress();
		String usuario = event.getAuthentication().getPrincipal().toString();
		String senha = event.getAuthentication().getCredentials().toString();
		
		String message = "[seguranca][autenticacao] Tentativa de login falhou(IP: %s | LOGIN: %s | SENHA: %s)";
		logger.info(String.format(message, ip, usuario, senha));
	}

}
