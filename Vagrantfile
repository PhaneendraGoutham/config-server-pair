VAGRANTFILE_API_VERSION = "2"
ANSIBLE_INVENTORY_DIR   = '.vagrant/provisioners/ansible/inventory'

Vagrant.configure(VAGRANTFILE_API_VERSION) do |config|
  config.vm.box = "centos/7"

  (1..2).each do |i|
    config.vm.define "host#{i}-local" do |node|
      node.vm.hostname = "host#{i}-local"
      node.vm.network :private_network, ip: "192.168.33.#{i+1}"
      node.vm.network "forwarded_port", guest: "8080", host: "808#{i}"

      node.vm.provider :virtualbox do |node|
        node.customize ["modifyvm", :id, "--natdnshostresolver1", "on"]
        node.customize ["modifyvm", :id, "--memory", 512]
      end

      node.vm.provision "shell", inline: <<-SHELL
            sudo yum -y install epel-release
            sudo yum -y install net-tools.x86_64
            sudo yum -y install telnet.x86_64
            sudo yum -y install bind-utils
            sudo yum -y install nmap
      SHELL

    end
  end

end