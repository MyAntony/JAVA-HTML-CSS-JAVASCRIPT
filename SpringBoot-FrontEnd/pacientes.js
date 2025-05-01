document.addEventListener("DOMContentLoaded", carregarPacientes)

function carregarPacientes()
{
    fetch('http://localhost:8080/pacientes')
    .then(response =>
    {
        if(!response.ok)
        {
            throw new Error('Erro ao carregar os pacientes: ')
        }
        return response.json()
    })

    .then(pacientes =>
    {
        const lista = document.getElementById('listaPacientes')
        lista.innerHTML = '' // Limpa a lista antes de adicionar os novos usuários

        if(pacientes.length === 0)
        {
            lista.innerHTML = '<li>Nenhum paciente encontrado.</li>'
            return;
        }

        pacientes.forEach(paciente =>
        {
            const item = document.createElement('li')
            item.innerHTML = `<strong>Nome:</strong> ${paciente.nome}<br>
            <strong>E-mail:</strong> ${paciente.email}`
            lista.appendChild(item)
        })
        
        .catch(error =>
        {
            document.getElementById('listaPacientes').innerHTML = '<li>Erro ao carregar os pacientes.</li>'
        })
    })
}