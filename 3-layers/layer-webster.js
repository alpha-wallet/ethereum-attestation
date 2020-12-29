
/*
 * Webster code pseudocode - Webster is a fictional web developer
 * Negotiator and Authenticators are imported, both from Oleg's code
 */

// create an negotiator with the filter condition of class equal to VIP
const negotiator = new Negotiator({ "ticketClass": "VIP"});

// negotiate() may ask users which tokens are permitted to be used on this site
// it also may open the iframe to ticket.devcon.org
negotiator.negotiate().then(() => {
    // user's first VIP ticket is their "my precious"
    const myPrecious = negotiator.getTokenInstances()[0];

    // here you can get attributes of myPrecious for business use such as
    const ticketId = myPrecious.ticketId;

    // if the website needs to authenticate the user
    const addr = await Authenticator.assertOwnerAddress(myPrecious); // may opens iframe in modal - attestation.id

    // here code to answer a server challenge with web3's signing code.

    // ------------------------------------------------------------------

    // if the website needs to assemble a transaction
    // such as a voting transaction

    // getting authentication string to be used in the transaction
    const useDevconTicket = await Authenticator.getAuthenticationBlob(myPrecious) // may open hidden iframe

    // here is the web3 transaction creation and sending code.
    const tx = ({from: "0x80980980", to: "0x80234", gas: 40000, value:0 });

    // vote for candidate 6 (reference to The Prisoner)
    tx['data'] = myContract.methods.myMethod(6, useDevconTicket).encodeABI();

    const signPromise = web3.eth.accounts.signTransaction(tx, privateKey);
})
