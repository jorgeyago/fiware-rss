/**
 * Copyright (C) 2015, CoNWeT Lab., Universidad Politécnica de Madrid
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package es.tid.fiware.rss.ws;

import es.tid.fiware.rss.model.RSSProvider;
import es.tid.fiware.rss.oauth.model.ValidatedToken;
import es.tid.fiware.rss.oauth.service.OauthManager;
import es.tid.fiware.rss.service.SettlementManager;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author fdelavega
 */
@Path("/")
@WebService(serviceName = "providers", name="providers")
public class ProviderService {

    @Autowired
    OauthManager oauthManager;

    @Autowired
    SettlementManager settlementManager;

    /**
     * 
     * @param authToken
     * @param providerInfo
     * @throws Exception
     * @return 
     */
    @WebMethod
    @POST
    @Consumes("application/json")
    public Response createProvider(@HeaderParam("X-Auth-Token") final String authToken,
            RSSProvider providerInfo) throws Exception{

        ValidatedToken validToken = oauthManager.checkAuthenticationToken(authToken);

        // Create the a new provider for the store represented by the User (AggregatorID)
        settlementManager.runCreateProvider(
            providerInfo.getProviderId(),
            providerInfo.getProviderName(),
            validToken.getEmail());

        ResponseBuilder rb = Response.status(Response.Status.CREATED.getStatusCode());
        return rb.build();
    }
}